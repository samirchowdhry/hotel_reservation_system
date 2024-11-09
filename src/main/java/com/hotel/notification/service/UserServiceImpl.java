package com.hotel.notification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

import com.hotel.notification.dao.UserDao;
import com.hotel.notification.model.User;

@Repository
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }


    @Override
    public Boolean addUsers(List<User> user) {
        List<User> task = userDao.addUser(user);
        if (task != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User updateUser(User log, Integer id) {
        return userDao.updateUser(log, id);
    }

    @Override
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);

    }
}
