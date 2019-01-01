package org.com.ck.config;

import java.util.Properties;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = { "org.com.ck.dao" })
public class MybitesConfig {
	
/*	@Bean
	public PagePluginHigh pagePluginHigh() {
		PagePluginHigh pagePluginHigh = new PagePluginHigh();
		Properties p = new Properties();
		p.setProperty("pageSqlId", ".*ListPage.*");
		p.setProperty("dialect", "mysql");
		pagePluginHigh.setProperties(p);
		return pagePluginHigh;
	}*/
}
