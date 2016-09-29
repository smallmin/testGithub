package com.smallmin.TrySpringBoot.Service;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.smallmin.TrySpringBoot.Dao.UserDao;
import com.smallmin.TrySpringBoot.Enity.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	
	@Override
	public Collection<User> getUsers() {
		return userDao.findAll();
	}

	@Override
	public User getUser(Long id) {
		return userDao.findOne(id);
	}

	@Override
	public User create(User user) {
		if(user.getId()!=null){
			//Cannot create with a specified ID
			return null;
		}
		return userDao.save(user);
	}

	@Override
	public User update(User user) {
		if(userDao.findOne(user.getId())==null){
			return null;
		}
		return userDao.save(user);
	}
	
	@Override
	public void delete(Long id) {
		userDao.delete(id);
	}
	
}
