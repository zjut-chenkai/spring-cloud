package org.com.ck.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class TestController {
	
	@RequestMapping("/http")
	public String http() {
		return "http";
	}
	
	@RequestMapping("/registry")
	public String registry() {
		return "registry";
	}
}
