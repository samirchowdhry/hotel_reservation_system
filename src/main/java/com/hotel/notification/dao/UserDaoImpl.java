package com.hotel.notification.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.notification.model.User;
import com.hotel.notification.repositories.UserRepository;
@Repository
public class UserDaoImpl implements UserDao {
	@Autowired 
	private UserRepository repository;

	@Override
	public List<User> addUser(List<User> tasks) {
		return repository.saveAll(tasks);
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public User updateUser(User user, Integer id) {
		user.setId(id);
		
		return repository.save(user);
		 
	}

	@Override
	public void deleteUser(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}



}
