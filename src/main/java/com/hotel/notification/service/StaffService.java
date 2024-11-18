package com.hotel.notification.service;

import com.hotel.notification.model.Staff;
import com.hotel.notification.repositories.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class StaffService {

    @Autowired
    StaffRepo staffRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Boolean addStaff(@RequestBody Staff staff) throws Exception {

        if (staff != null) {

            Staff staffCheck = staffRepo.findUsernameByStaff(staff.getEmail());
            if(staffCheck != null){
                return false;
            }
            else {
                staff.setPassword(bCryptPasswordEncoder.encode(staff.getPassword()));
               Staff staffSave = staffRepo.save(staff);
               if(staffSave != null){
                   return true;
               }
               else{
                   return false;
               }
            }

        }

        return null;
    }

}
