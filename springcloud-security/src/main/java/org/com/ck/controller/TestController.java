package org.com.ck.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

	@RequestMapping("/getCurrentUser")
	public Object getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("user-me:{}" + authentication.getName());
		return authentication;
	}
}
