package org.com.ck.config;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
@EnableJms
public class ActiveMQConfig {

	@Bean
	public Queue springbootQueue() {
		return new ActiveMQQueue("springboot-activemq-queue");
	}

	@Bean
	public Topic springbootTopic() {
		return new ActiveMQTopic("springboot-activemq-topic");
	}

	@Bean
	public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory,
			DefaultJmsListenerContainerFactoryConfigurer configurer) {
		DefaultJmsListenerContainerFactory jmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();

		/**
		 * 把JMS参数配置到ListenerContainer
		 */
		configurer.configure(jmsListenerContainerFactory, activeMQConnectionFactory);
		jmsListenerContainerFactory.setConnectionFactory(activeMQConnectionFactory);

		/**
		 * 如果JMS的acknowledgemode设置的是客户端手动提交，这时spring会处理成自动提交，所以手动提交设置不起作用，因此手动提交需要这里设置成ActiveMq提供的模式，数字4表示
		 */
		jmsListenerContainerFactory.setSessionAcknowledgeMode(4);
		/**
		 * 针对Topic开启发布-订阅模式
		 */
		jmsListenerContainerFactory.setPubSubDomain(true);
		/**
		 * 使用消息转换器
		 */
		jmsListenerContainerFactory.setMessageConverter(jacksonJmsMessageConverter());
		// log.info(">>>Topic对应的监听器容器创建成功");

		return jmsListenerContainerFactory;
	}

	@Bean
	public JmsListenerContainerFactory<?> jmsListenerContainerQueue(ConnectionFactory activeMQConnectionFactory,
			DefaultJmsListenerContainerFactoryConfigurer configurer) {
		DefaultJmsListenerContainerFactory jmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();

		/**
		 * 把JMS参数配置到ListenerContainer
		 */
		configurer.configure(jmsListenerContainerFactory, activeMQConnectionFactory);
		jmsListenerContainerFactory.setConnectionFactory(activeMQConnectionFactory);

		/**
		 * 如果设置JMS的acknowledgemode=2，即客户端手动确认，这时spring会处理成自动确认，所以手动确认设置不起作用，
		 * 因此手动提交需要设置acknowledgemode=4，此确认模式是activemq定义的非JMS标准
		 */
		jmsListenerContainerFactory.setSessionAcknowledgeMode(4);
		/**
		 * 1、开启本地事务控制，如果想要手动确认消息，需要关闭本地事务，
		 * 
		 * @see AbstractMessageListenerContainer#commitIfNecessary
		 *      2、开启本地事务控制时，可以通过会话回滚（最简单的方式是抛出异常）达到手动确认模式的效果
		 */
		jmsListenerContainerFactory.setSessionTransacted(false);
		jmsListenerContainerFactory.setCacheLevelName("CACHE_CONSUMER");
		/**
		 * 使用消息转换器
		 */
		jmsListenerContainerFactory.setMessageConverter(jacksonJmsMessageConverter());
		// log.info(">>>Queue对应的监听器容器创建成功");

		return jmsListenerContainerFactory;
	}

	@Bean
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}

}
