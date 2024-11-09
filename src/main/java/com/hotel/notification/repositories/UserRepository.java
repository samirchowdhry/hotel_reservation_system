package com.hotel.notification.repositories;


import com.hotel.notification.model.userDetailsInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hotel.notification.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    
    @Override
    Optional<User> findById(Integer integer);

    @Query(value = "SELECT * FROM hotel.`user` where username= ?1 ", nativeQuery=true)
    User findByUsername(String queryString1);


}
