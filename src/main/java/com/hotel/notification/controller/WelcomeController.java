package com.hotel.notification.controller;

import com.hotel.notification.model.User;
import com.hotel.notification.utils.JwtUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")

public class WelcomeController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;



    @PostMapping("/authenticate")
    public ResponseEntity<String> generateToken(@RequestBody User authRequest) throws Exception {

        try {

            UsernamePasswordAuthenticationToken us =  new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
            return  new ResponseEntity<>(new JSONObject().put("token",  "Bearer " +jwtUtil.generateToken(authRequest.getUsername())).toString(), HttpStatus.OK);

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return  new ResponseEntity<>(new JSONObject().put("mesage",  "inavalid username/password").toString(), HttpStatus.OK);
    }
}
