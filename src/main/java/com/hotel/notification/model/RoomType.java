package com.hotel.notification.model;

import javax.persistence.*;

@Entity
public class RoomType {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String roomType;

    private Float roomPerPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getRoomPerPrice() {
        return roomPerPrice;
    }

    public void setRoomPerPrice(Float roomPerPrice) {
        this.roomPerPrice = roomPerPrice;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
}
