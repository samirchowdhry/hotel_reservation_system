package com.hotel.notification.controller;

import com.hotel.notification.model.User;
import com.hotel.notification.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("notification")
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(path = "/getUserById")
    public ResponseEntity<List<User>> getUserById() {
        // This returns a JSON or XML with the users
        userRepository.findAll();
        return new ResponseEntity<>( userRepository.findAll(), HttpStatus.OK);

    }



}
