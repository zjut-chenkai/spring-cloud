package org.com.ck.server.impl;

import org.com.ck.bean.User;
import org.com.ck.bean.util.UserCode;
import org.com.ck.dao.UserDao;
import org.com.ck.server.UserService;
import org.com.ck.util.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public ResponseObject login(JSONObject body) {

		User user = JSONObject.toJavaObject(body, User.class);
		user = userDao.getUser(user);

		if (null != user) {
			return ResponseObject.getResponseObject(UserCode.USER_LOGIN_SUCCESS, user);
		} else {
			return ResponseObject.getResponseObject(UserCode.USER_LOGIN_FAIL);
		}
	}

}
