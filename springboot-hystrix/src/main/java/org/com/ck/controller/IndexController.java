package org.com.ck.controller;

import org.com.ck.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class IndexController {

	@Autowired
	private IndexService indexService;

	@RequestMapping("/index")
	public String index(@RequestBody JSONObject obj) {
		System.out.println("dsadsadsadsada");
		return indexService.index(obj);
	}
}
