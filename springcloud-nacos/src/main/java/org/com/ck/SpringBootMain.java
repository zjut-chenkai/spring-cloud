package org.com.ck;

import org.com.ck.config.NacosConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootMain {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMain.class, args);
	}

	@RestController
	static class TestController {

		@Autowired
		private NacosConfig nacosConfig;

		@GetMapping("/test")
		public String hello() {
			System.out.println(nacosConfig.getMap().toString());
			return nacosConfig.getTest();
		}

	}
}
