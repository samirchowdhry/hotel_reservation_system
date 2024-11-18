package com.hotel.notification.controller;

import com.hotel.notification.model.AdditionalServices;
import com.hotel.notification.model.Booking;
import com.hotel.notification.service.AdditionalServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Service
@RequestMapping("notification")
public class AdditionalServicesController {

    @Autowired
    AdditionalServicesService additionalServicesService;


    @GetMapping(path = "/getAdditionalServices")
    public ResponseEntity<List<AdditionalServices>> getAdditionalServices() throws Exception {

        List<AdditionalServices> additionalServicesList = additionalServicesService.getAdditionalServices();
        if(additionalServicesList.size() > 0){
            return new ResponseEntity<>(additionalServicesList, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
