package org.com.ck.server;

import org.com.ck.util.ResponseObject;

import com.alibaba.fastjson.JSONObject;

public interface UserGroupFriendService {

	public ResponseObject getUserGroupFriendList(JSONObject body);

	public ResponseObject addUserGroupFriend(JSONObject body);

	public ResponseObject updUserGroupFriend(JSONObject body);

	public ResponseObject delUserGroupFriend(String userGroupFriendId);
}
