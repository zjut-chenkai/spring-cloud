/**
 * @ spring-cloud-eureka-hystrix-consumer
 * @ com.cmcc.dhome.config
 * @ HytrixConfig.java
 * 
 * @author Shi Junjian  2018年10月31日
 * Copyright © CMCC Corporation. All rights reserved.
 */
package org.com.ck.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

/**
 * springboot2.0,必须添加此配置，否则hytrix dashboard无法监控到数据
 * @author Shi Junjian 
 * @date 2018年10月31日 - 下午3:31:52
 * @history 
 * 		 2018年10月31日 - 下午3:31:52 Shi Junjian  create.
 */
@Configuration
public class HytrixConfig {
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
