package org.com.ck.service.impl;

import org.com.ck.service.FallBackService;
import org.com.ck.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class IndexServiceImpl implements IndexService {
	
	@Autowired
	private FallBackService fallBackService;

	@HystrixCommand(fallbackMethod = "getOrderPageListFallback")
	@Override
	public String index(JSONObject obj) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "chenkai";
	}

	public String getOrderPageListFallback(@RequestBody JSONObject obj) {
		System.out.println("===================== 执行降级策略");
		System.out.println(fallBackService.getMsg());
		return "ck";
	}
}
