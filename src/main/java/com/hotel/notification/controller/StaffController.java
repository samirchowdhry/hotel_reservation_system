package com.hotel.notification.controller;

import com.hotel.notification.model.Staff;
import com.hotel.notification.model.User;
import com.hotel.notification.repositories.StaffRepo;
import com.hotel.notification.repositories.UserRepository;
import com.hotel.notification.service.StaffService;
import com.hotel.notification.utils.JwtUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Service
@RequestMapping("notification")
public class StaffController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    StaffRepo staffRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    StaffService staffService;

    @PostMapping(path = "/addStaff")
    public ResponseEntity<String> addStaff(@RequestBody Staff staff) throws Exception {

        if (staff != null) {
            Boolean staffCheck = staffService.addStaff(staff);
            if(staffCheck == true) {
                return new ResponseEntity<>("message : User Save Successfully", HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>( "message : User already exists", HttpStatus.OK);
            }

        }

        return null;
    }





    @PostMapping("/authenticateStaff")
    public ResponseEntity<String> generateToken(@RequestBody Staff staffRequest) throws Exception {

        try {

            UsernamePasswordAuthenticationToken us =  new UsernamePasswordAuthenticationToken(staffRequest.getEmail(), staffRequest.getPassword());

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(staffRequest.getEmail(), staffRequest.getPassword())
            );
            return  new ResponseEntity<>(new JSONObject().put("token",  "Bearer " +jwtUtil.generateToken(staffRequest.getEmail())).toString(), HttpStatus.OK);

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return  new ResponseEntity<>(new JSONObject().put("mesage",  "inavalid username/password").toString(), HttpStatus.OK);
    }



}
