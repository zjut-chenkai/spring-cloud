package org.com.ck.bean;

import java.io.Serializable;

public class UserGroupFriendInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String userGroupFriendId;
	private String userGroupId;
	private String friendId;
	private String userId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserGroupFriendId() {
		return userGroupFriendId;
	}

	public void setUserGroupFriendId(String userGroupFriendId) {
		this.userGroupFriendId = userGroupFriendId;
	}

	public String getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(String userGroupId) {
		this.userGroupId = userGroupId;
	}

	public String getFriendId() {
		return friendId;
	}

	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
