package com.hotel.notification.repositories;

import com.hotel.notification.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface RoomRepo extends JpaRepository<Room,Integer> {

    @Query(value = "select * from room r where room_type_id = ?1 and is_available = 0 order by id LIMIT ?2",nativeQuery = true)
    List<Room> getRoomsByRoomId(Integer roomId, Integer roomType);

    @Modifying
    @Transactional
    @Query(value = "update room set is_available = :isAvailable where id IN :roomId", nativeQuery=true)
    void updateRoomStatus(Boolean isAvailable,List<Integer> roomId);


}
