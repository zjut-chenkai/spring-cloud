package org.com.ck.controller;

import org.com.ck.server.UserGroupService;
import org.com.ck.util.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

@RestController
@RequestMapping("/group")
public class UserGroupController {
	
	@Autowired
	private UserGroupService userGroupService;
	
	@RequestMapping("/get")
	public ResponseObject getUserGroupList(@RequestBody JSONObject body) {
		return userGroupService.getUserGroupList(body);
	}
}
