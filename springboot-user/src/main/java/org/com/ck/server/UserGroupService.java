package org.com.ck.server;

import org.com.ck.util.ResponseObject;

import com.alibaba.fastjson.JSONObject;

public interface UserGroupService {
	
	public ResponseObject getUserGroupList(JSONObject body);
}
