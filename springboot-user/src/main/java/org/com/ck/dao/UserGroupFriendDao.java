package org.com.ck.dao;

import java.util.List;

import org.com.ck.bean.UserGroupFriendInfo;

public interface UserGroupFriendDao {
	public List<UserGroupFriendInfo> getUserGroupFriendList(String userGroupId);

	public int addUserGroupFriendInfo(UserGroupFriendInfo userGroupFriendInfo);

	public int updUserGroupFriendInfo(UserGroupFriendInfo userGroupFriendInfo);

	public int delUserGroupFriendInfo(String userGroupFriendId);
}
