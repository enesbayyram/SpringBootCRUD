package com.jforce.service;

import java.util.List;

import com.jforce.model.User;

public interface IUserService {

	public void save(User user);
	
	public void delete(Long userid);
	
	public void update(User user);
	
	public User getUserById(Long userid);
	
	public List<User> getUserList();
	
}
