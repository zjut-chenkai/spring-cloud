package org.com.ck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringBootMain {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMain.class, args);
	}

}