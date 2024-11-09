package com.hotel.notification.service;

import java.util.List;

import com.hotel.notification.model.User;

public interface UserService {

	List<User> getAllUsers();

	Boolean addUsers(List<User> newTask);

	User updateUser(User log, Integer id);

	void deleteUser(Integer id);

}
