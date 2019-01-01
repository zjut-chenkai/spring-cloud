package org.com.ck.dao;

import java.util.List;

import org.com.ck.bean.User;

public interface UserDao {

	public int getUserCountByCondition(User user);
	
	public List<User> getUserList();
	
	public User getUser(User user);
}
