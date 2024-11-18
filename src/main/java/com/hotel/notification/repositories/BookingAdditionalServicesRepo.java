package com.hotel.notification.repositories;

import com.hotel.notification.model.BookingAdditionalServices;
import com.hotel.notification.model.BookingRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingAdditionalServicesRepo extends JpaRepository<BookingAdditionalServices,Integer> {

    @Query(value = "select * from booking_additional_services where services_id is null",nativeQuery = true)
    List<BookingAdditionalServices> getServicesNull();

}
