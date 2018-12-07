package org.com.ck.server;

import org.com.ck.util.ResponseObject;

import com.alibaba.fastjson.JSONObject;

public interface UserService {
	
	public ResponseObject login(JSONObject body);
}
