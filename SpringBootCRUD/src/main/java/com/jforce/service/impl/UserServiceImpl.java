package com.jforce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jforce.dao.IUserRepository;
import com.jforce.model.User;
import com.jforce.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	
	private IUserRepository userRepository;

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public void delete(Long userid) {
		userRepository.delete(userid);
	}
	
	@Override
	public void update(User user) {
		userRepository.update(user);
	}

	@Override
	public User getUserById(Long userid) {
		return userRepository.getUserById(userid);
	}

	@Override
	public List<User> getUserList() {
		return userRepository.getUserList();
	}

	@Autowired // spring container içinde oluşmuş UserRepositoryImpl bean'ı set metoduna enjecte ettik.
	public void setUserRepository(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	

}
