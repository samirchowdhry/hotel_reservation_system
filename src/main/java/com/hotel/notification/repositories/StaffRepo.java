package com.hotel.notification.repositories;

import com.hotel.notification.model.Staff;
import com.hotel.notification.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StaffRepo extends JpaRepository<Staff,Integer> {

    @Query(value = "SELECT * FROM hotel.staff where email= ?1 ", nativeQuery=true)
    Staff findUsernameByStaff(String queryString1);

}
