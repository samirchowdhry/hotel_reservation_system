package com.hotel.notification.controller;

import com.hotel.notification.model.User;
import com.hotel.notification.repositories.UserRepository;
import com.hotel.notification.service.AuthService;
import com.hotel.notification.utils.MailWithMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Service
@RequestMapping("notification")
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MailWithMessage mailWithMessage;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    AuthService authService;

//    @GetMapping(path = "/getUserById")
//    public ResponseEntity<List<User>> getUserById() throws Exception {
//        // This returns a JSON or XML with the users
//        userRepository.findAll();
//        return new ResponseEntity<>( userRepository.findAll(), HttpStatus.OK);
//
//    }

    @PostMapping(path = "/addCustomer")
    public ResponseEntity<String> addCustomer(@RequestBody User user) throws Exception {

        if (user != null) {

            Boolean customer = authService.addCustomer(user);
            if(customer == true) {
                return new ResponseEntity<>("message : User Save Successfully", HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>( "message : User already exists", HttpStatus.OK);
            }

        }

        return null;
    }


}
