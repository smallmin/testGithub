package com.smallmin.TrySpringBoot.Service;

import java.math.BigInteger;
import java.util.Collection;

import com.smallmin.TrySpringBoot.Enity.User;

public interface UserService {
	
	Collection<User> getUsers();
	
	User getUser(Long id);
	
	User create(User user);
	
	User update(User user);
	
	void delete(Long id);


	
}
