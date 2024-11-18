package com.hotel.notification.service;

import com.hotel.notification.model.User;
import com.hotel.notification.repositories.UserRepository;
import com.hotel.notification.utils.MailWithMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AuthService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MailWithMessage mailWithMessage;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Boolean addCustomer(@RequestBody User user) throws Exception {

        if (user != null) {

            User userCheck = userRepository.findByUsername(user.getEmail());

            if(userCheck != null){
                return false;
            }
            else {

                user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
                User userStatus = userRepository.save(user);

                if (userStatus != null) {
                    return true;
                } else {
                    return false;
                }
            }


        }

        return null;
    }

}
