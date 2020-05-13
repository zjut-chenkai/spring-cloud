package org.com.ck.controller;

import org.com.ck.remote.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

@RestController
public class ConsumerController {

	@Autowired
	HelloRemote helloRemote;

	@RequestMapping("/bodyIndex")
	public JSONObject bodyIndex(@RequestBody JSONObject body) {
		return helloRemote.bodyIndex(body);
	}
	
}