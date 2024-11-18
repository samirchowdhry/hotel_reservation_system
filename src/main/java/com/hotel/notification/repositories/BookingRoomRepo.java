package com.hotel.notification.repositories;

import com.hotel.notification.model.BookingRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingRoomRepo extends JpaRepository<BookingRoom,Integer> {

    @Query(value = "select * from booking_room where booking_id is null",nativeQuery = true)
    List<BookingRoom> getRoomNull();
}
