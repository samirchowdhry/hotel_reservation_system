package com.hotel.hotelreservationsystem.Model.Repository;

import com.hotel.hotelreservationsystem.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin,Integer> {
}
