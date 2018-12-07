package org.com.ck.server.impl;

import java.util.ArrayList;
import java.util.List;

import org.com.ck.bean.User;
import org.com.ck.bean.util.UserCode;
import org.com.ck.server.UserService;
import org.com.ck.util.ResponseObject;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public ResponseObject login(JSONObject body) {
		List<String> users = new ArrayList<>();
		users.add("chenkai");
		users.add("wangwen");
		User user = JSONObject.toJavaObject(body, User.class);
		if (users.contains(user.getUsername()) && "123456".equals(user.getPassword())) {
			return ResponseObject.getResponseObject(UserCode.USER_LOGIN_SUCCESS);
		} else {
			return ResponseObject.getResponseObject(UserCode.USER_LOGIN_FAIL);
		}
	}

}
