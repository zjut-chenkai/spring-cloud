package org.com.ck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@RestController
public class SpringBootMain {
	
	@Autowired
	private RestTemplate restTemplate;

	@Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
	
	@RequestMapping("/hi")
	public String home() {
		System.out.println("jinlia---------------");
		
		return restTemplate.getForEntity("http://springcloud-zk-server/hi", String.class).getBody();
	}

	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMain.class, args);
	}

}