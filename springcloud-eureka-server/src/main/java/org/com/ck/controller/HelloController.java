package org.com.ck.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String index() {
		System.out.println("接入请求。。。");
		return "hello " + "111" + "，this is first messge";
	}
}