package org.com.ck.server.impl;

import java.util.List;

import org.com.ck.bean.UserGroupInfo;
import org.com.ck.bean.util.UserCode;
import org.com.ck.dao.UserGroupDao;
import org.com.ck.server.UserGroupService;
import org.com.ck.util.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

@Service
public class UserGroupServiceImpl implements UserGroupService {

	@Autowired
	private UserGroupDao userGroupDao;

	@Override
	public ResponseObject getUserGroupList(JSONObject body) {

		String userId = body.getString("userId");
		List<UserGroupInfo> userGroupInfos = userGroupDao.getUserGroupList(userId);
		return ResponseObject.getResponseObject(UserCode.SUCCESS, userGroupInfos);
	}

}
