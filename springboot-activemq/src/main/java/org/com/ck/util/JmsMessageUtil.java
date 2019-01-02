package org.com.ck.util;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class JmsMessageUtil {

	@Resource
	JmsMessagingTemplate jmsMessagingTemplate;

	@Async
	public void sendMsg(Destination dest, Object msg) {
		jmsMessagingTemplate.convertAndSend(dest, msg);
	}
}
