package com.hotel.notification.dao;

import java.util.List;

import com.hotel.notification.model.User;

public interface UserDao {

	List<User> addUser(List<User> user);

	List<User> getUsers();

	User updateUser(User task, Integer id);

	void deleteUser(Integer id);

	List<User> getAllUsers();

}
