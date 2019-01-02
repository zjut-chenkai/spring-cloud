package org.com.ck.jms.listener;

import javax.jms.Message;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

@Component
public class SpringbootQueue {

	@JmsListener(destination="springboot-activemq-queue", containerFactory="jmsListenerContainerQueue")
	public void receiveFromQueue(JSONObject obj, Message msg) {
		System.out.println("接收到消息！！！");
	}
}
