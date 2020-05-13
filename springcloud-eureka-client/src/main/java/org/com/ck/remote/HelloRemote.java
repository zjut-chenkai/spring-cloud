package org.com.ck.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;

//这里client的name必须和服务提供者的名字一致
@FeignClient(name = "HEALTH-ALGORITHM", fallback = HelloRemoteHystrix.class)
public interface HelloRemote {

	@RequestMapping(value = "/health-algorithm/bodyIndex", method = RequestMethod.POST)
	public JSONObject bodyIndex(JSONObject body);

}
