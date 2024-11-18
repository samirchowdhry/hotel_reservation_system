package com.hotel.notification.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class BookingAdditionalServices {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Integer servicesType;

    public BookingAdditionalServices() {
    }

    public BookingAdditionalServices(Integer servicesType) {
        this.servicesType = servicesType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getServicesType() {
        return servicesType;
    }

    public void setServicesType(Integer servicesType) {
        this.servicesType = servicesType;
    }

    @Override
    public String toString() {
        return "BookingAdditionalServices{" +
                "id=" + id +
                ", servicesType=" + servicesType +
                '}';
    }
}
