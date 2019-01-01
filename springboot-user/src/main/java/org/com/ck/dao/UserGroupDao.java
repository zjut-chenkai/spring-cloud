package org.com.ck.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.com.ck.bean.UserGroupInfo;

public interface UserGroupDao {
	
	public List<UserGroupInfo> getUserGroupList(@Param("userId") String userId);
	
	public int addUserGroupInfo(UserGroupInfo userGroupInfo);
	
	public int updUserGroupInfo(UserGroupInfo userGroupInfo);
	
	public int delUserGroupInfo(String userGroupId);
	
}
