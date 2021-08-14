package com.jforce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jforce.model.User;
import com.jforce.service.IUserService;

@RestController
@RequestMapping(value = "/rest")
public class UserController {
	
	private IUserService userService;
	

	@GetMapping(value  = "/users")
	public ResponseEntity<List<User>> getUserList()
	{
		List<User> userList= userService.getUserList();
		return ResponseEntity.ok(userList);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id)
	{
		User user= userService.getUserById(id);
		return ResponseEntity.ok(user);
	}

	@PostMapping(value = "/users")
	public ResponseEntity<?> saveUser(@RequestBody User user)
	{
		userService.save(user);
		return ResponseEntity.ok("User Created.");
	}
	
	@DeleteMapping(value = "/users/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id)
	{
		userService.delete(id);
		return ResponseEntity.ok("User deleted...");
	}
	
	@PutMapping(value = "/users")
	public ResponseEntity<?> updateUser(@RequestBody User user)
	{
		userService.update(user);
		return ResponseEntity.ok("User updated...");
	}
	
	
	
	
	
	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
}
