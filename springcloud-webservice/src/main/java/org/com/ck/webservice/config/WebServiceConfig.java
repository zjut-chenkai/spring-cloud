package org.com.ck.webservice.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.com.ck.webservice.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qiyu
 * @date 2020/2/26 14:57
 * @description
 */
@Configuration
public class WebServiceConfig {
	// @Bean("cxfServletRegistration")
	@Bean("cxfServletRegistration")
	public ServletRegistrationBean dispatcherServlet() {
		// 注册servlet 拦截/ws 开头的请求 不设置 默认为：/services/*
		return new ServletRegistrationBean(new CXFServlet(), "/ws/*");
	}

	@Autowired
	private Bus bus;

	@Autowired
	CommonService commonService;

	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(bus, commonService);
		endpoint.publish("/CommonService");
		return endpoint;
	}
}
