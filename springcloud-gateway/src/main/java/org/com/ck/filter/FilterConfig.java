package org.com.ck.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class FilterConfig {
	@Bean
    public TestGatewayFilterFactory testGatewayFilterFactory(){
        return new TestGatewayFilterFactory();
    }
}
