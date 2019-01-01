package org.com.ck.server.impl;

import java.util.List;

import org.com.ck.bean.UserGroupFriendInfo;
import org.com.ck.bean.util.UserCode;
import org.com.ck.dao.UserGroupFriendDao;
import org.com.ck.server.UserGroupFriendService;
import org.com.ck.util.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.alibaba.fastjson.JSONObject;

@Service
public class UserGroupFriendServiceImpl implements UserGroupFriendService {

	@Autowired
	private UserGroupFriendDao userGroupFriendDao;

	@Override
	public ResponseObject getUserGroupFriendList(@RequestBody JSONObject body) {

		String userGroupId = body.getString("userGroupId");
		List<UserGroupFriendInfo> userGroupFriendInfos = userGroupFriendDao.getUserGroupFriendList(userGroupId);
		return ResponseObject.getResponseObject(UserCode.SUCCESS, userGroupFriendInfos);
	}

	@Override
	public ResponseObject addUserGroupFriend(JSONObject body) {
		UserGroupFriendInfo userGroupFriendInfo = JSONObject.toJavaObject(body, UserGroupFriendInfo.class);
		userGroupFriendDao.addUserGroupFriendInfo(userGroupFriendInfo);
		return ResponseObject.successful();
	}

	@Override
	public ResponseObject updUserGroupFriend(JSONObject body) {
		UserGroupFriendInfo userGroupFriendInfo = JSONObject.toJavaObject(body, UserGroupFriendInfo.class);
		userGroupFriendDao.updUserGroupFriendInfo(userGroupFriendInfo);
		return ResponseObject.successful();
	}

	@Override
	public ResponseObject delUserGroupFriend(String userGroupFriendId) {
		userGroupFriendDao.delUserGroupFriendInfo(userGroupFriendId);
		return ResponseObject.successful();
	}

}
