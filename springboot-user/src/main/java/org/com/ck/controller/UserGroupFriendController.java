package org.com.ck.controller;

import org.com.ck.server.UserGroupFriendService;
import org.com.ck.util.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

@RestController
@RequestMapping("/friend")
public class UserGroupFriendController {

	@Autowired
	private UserGroupFriendService userGroupFriendService;

	@RequestMapping("/list")
	public ResponseObject getUserGroupList(@RequestBody JSONObject body) {
		return userGroupFriendService.getUserGroupFriendList(body);
	}

	@RequestMapping("/add")
	public ResponseObject addUserGroupList(@RequestBody JSONObject body) {
		return userGroupFriendService.addUserGroupFriend(body);
	}

	@RequestMapping("/upd")
	public ResponseObject updUserGroupList(@RequestBody JSONObject body) {
		return userGroupFriendService.updUserGroupFriend(body);
	}

	@RequestMapping("/del")
	public ResponseObject delUserGroupList(@RequestBody JSONObject body) {
		return userGroupFriendService.delUserGroupFriend(body.getString("userGroupFriendId"));
	}

}
