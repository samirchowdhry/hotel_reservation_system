package com.hotel.notification.service;

import com.hotel.notification.model.AdditionalServices;
import com.hotel.notification.model.Booking;
import com.hotel.notification.repositories.AdditionalServicesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdditionalServicesService {

    @Autowired
    AdditionalServicesRepo additionalServicesRepo;

    public List<AdditionalServices> getAdditionalServices(){

        if (additionalServicesRepo.findAll() != null) {
            return additionalServicesRepo.findAll();
        } else {
            return null;
        }
    }

}
