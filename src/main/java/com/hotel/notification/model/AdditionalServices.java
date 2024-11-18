package com.hotel.notification.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class AdditionalServices {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String serviceType;

    private Float price;

    public AdditionalServices() {
    }

    public AdditionalServices(String serviceType, Float price) {
        this.serviceType = serviceType;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "AdditionalServices{" +
                "id=" + id +
                ", serviceType='" + serviceType + '\'' +
                ", price=" + price +
                '}';
    }
}
