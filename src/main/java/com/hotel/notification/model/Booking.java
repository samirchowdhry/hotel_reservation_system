package com.hotel.notification.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Date startDate;

    private Date endDate;

    private Integer numberOfGuests;

    private Float price;

    private Float discount;

    private Time timestamp;

    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;

    @OneToOne
    @JoinColumn(name = "customer_user_id", referencedColumnName = "id")
    private User user;

    @OneToMany( cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="services_id",referencedColumnName = "id")
    private List<BookingAdditionalServices> additionalServices;

    @OneToMany( cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="booking_id",referencedColumnName = "id")
    private List<BookingRoom> bookingRooms;


    public Booking() {
    }

    public Booking(Date startDate, Date endDate, Integer numberOfGuests, Float price, Float discount, Time timestamp, Instant createdAt, Instant updatedAt, User user, List<BookingAdditionalServices> additionalServices, List<BookingRoom> bookingRooms) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfGuests = numberOfGuests;
        this.price = price;
        this.discount = discount;
        this.timestamp = timestamp;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user = user;
        this.additionalServices = additionalServices;
        this.bookingRooms = bookingRooms;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(Integer numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Time getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Time timestamp) {
        this.timestamp = timestamp;
    }

    public List<BookingAdditionalServices> getAdditionalServices() {
        return additionalServices;
    }

    public void setAdditionalServices(List<BookingAdditionalServices> additionalServices) {
        this.additionalServices = additionalServices;
    }

    public List<BookingRoom> getBookingRooms() {
        return bookingRooms;
    }

    public void setBookingRooms(List<BookingRoom> bookingRooms) {
        this.bookingRooms = bookingRooms;
    }



    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", numberOfGuests=" + numberOfGuests +
                ", price=" + price +
                ", discount=" + discount +
                ", timestamp=" + timestamp +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", user=" + user +
                ", additionalServices=" + additionalServices +
                ", bookingRooms=" + bookingRooms +
                '}';
    }
}
