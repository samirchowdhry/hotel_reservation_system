package com.hotel.notification.repositories;

import com.hotel.notification.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomTypeRepo extends JpaRepository<RoomType,Integer> {
}
