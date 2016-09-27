package com.smallmin.TrySpringBoot.Api;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smallmin.TrySpringBoot.Enity.User;
import com.smallmin.TrySpringBoot.Service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/")
	public String getIndex(){
		return "Hello Master!";
	}
	
	@RequestMapping(value = "/api/getusers")
	public Collection<User> getUsers() {
		return userService.getUsers();
	}
	
	@RequestMapping(value = "/api/getusers/{id}")
	public User getUser(@PathVariable("id") Long id){
		return userService.getUser(id);
	}
	
	@RequestMapping(
			value = "api/getusers",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public User addUser(@RequestBody User user) {
		return userService.create(user);
	}
	
	@RequestMapping(
			value = "api/getusers",
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public User updateUser(@RequestBody User user) {
		return userService.update(user);
	}
	
	@RequestMapping(
			value = "api/delete/{id}",
			method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("id") Long id){
		userService.delete(id);
	}
	
}
