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
		return new ActiveMQQueue("springboot.activemq.queue");
	}

	@Bean
	public Topic springbootTopic() {
		return new ActiveMQTopic("springboot.activemq.topic");
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
		 * 如果JMS的acknowledgemode设置的是客户端手动提交，这时spring会处理成自动提交，所以手动提交设置不起作用，
		 * 因此手动提交需要这里设置成ActiveMq提供的模式，数字4表示
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
System.err.println(">>>Topic对应的监听器容器创建成功");
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
		 * 如果JMS的acknowledgemode设置的是客户端手动提交，这时spring会处理成自动提交，所以手动提交设置不起作用，
		 * 因此手动提交需要这里设置成ActiveMq提供的模式，数字4表示
		 */
		jmsListenerContainerFactory.setSessionAcknowledgeMode(4);
		/**
		 * 开启事务控制
		 */
		jmsListenerContainerFactory.setSessionTransacted(true);
		jmsListenerContainerFactory.setCacheLevelName("CACHE_CONSUMER");
		/**
		 * 使用消息转换器
		 */
		jmsListenerContainerFactory.setMessageConverter(jacksonJmsMessageConverter());
		// log.info(">>>Queue对应的监听器容器创建成功");
		System.err.println(">>>>Queue对应的监听器容器创建成功");
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
