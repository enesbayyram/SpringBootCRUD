package com.jforce.dao;

import java.util.List;

import com.jforce.model.User;

public interface IUserRepository {

	public void save(User user);
	
	public int delete(Long userid);
	
	public void update(User user);
	
	public User getUserById(Long userid);
	
	public List<User> getUserList();
	
}
