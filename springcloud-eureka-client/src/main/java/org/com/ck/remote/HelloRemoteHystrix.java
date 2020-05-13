package org.com.ck.remote;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

@Component
public class HelloRemoteHystrix implements HelloRemote {

	@Override
	public JSONObject bodyIndex(JSONObject body) {
		JSONObject obj = new JSONObject();
		obj.put("message", "hello " + "222" + ", this messge send failed");
		return obj;
	}
}
