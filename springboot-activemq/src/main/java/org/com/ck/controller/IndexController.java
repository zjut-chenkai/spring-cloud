package org.com.ck.controller;

import javax.annotation.Resource;
import javax.jms.Queue;

import org.com.ck.util.JmsMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

@RestController
@RequestMapping("/index")
public class IndexController {

	@Resource
	JmsMessageUtil jmsMessageUtil;

	@Autowired
	Queue springbootQueue;

	@RequestMapping("/index")
	public String index() {
		JSONObject obj = new JSONObject();
		obj.put("ck", "123456");
		jmsMessageUtil.sendMsg(springbootQueue, obj);
		return "chenkai";
	}
}
