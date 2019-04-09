package org.com.ck.jms.listener;


import org.apache.activemq.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class SpringbootQueue {

	@JmsListener(destination="springboot.activemq.queue")
	public void receiveFromQueue(Message msg) {
		System.out.println("接收到消息！！！");
	}
}
