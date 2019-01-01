package org.com.ck;

import org.com.ck.websocket.WebsocketChatServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class SpringBootMain {

	public static void main(String[] args) {
		try {
			new WebsocketChatServer(8081).start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		SpringApplication.run(SpringBootMain.class, args);
	}

}