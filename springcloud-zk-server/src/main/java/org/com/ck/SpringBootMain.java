package org.com.ck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@RestController
public class SpringBootMain {

	@RequestMapping("/hi")
	public String home() {
		return "Hello zookeeper";
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMain.class, args);
	}

}