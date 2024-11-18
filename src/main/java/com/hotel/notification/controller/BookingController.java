package com.hotel.notification.controller;

import com.hotel.notification.model.Booking;
import com.hotel.notification.model.BookingRoom;
import com.hotel.notification.model.User;
import com.hotel.notification.service.BookingService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Service
@RequestMapping("booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping(path = "/createBooking")
    public ResponseEntity<String> addBooking(@RequestBody Booking booking) throws Exception {

        if (booking != null) {

            Boolean bookingCheck = bookingService.addBooking(booking);
            if(bookingCheck == true) {
                return new ResponseEntity<>(new JSONObject().put("message", "Room Successfully Booked").toString(),HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(new JSONObject().put("message", "error").toString(),HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }

        return null;
    }

    @PutMapping(path = "/updateBooking")
    public ResponseEntity<String> updateBooking(@RequestParam Integer id ,@RequestBody Booking booking) throws Exception {

        if (booking != null) {

            Boolean bookingCheck = bookingService.updateBooking(id,booking);
            if(bookingCheck == true) {
                return new ResponseEntity<>(new JSONObject().put("message", "Room Successfully Booked").toString(),HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(new JSONObject().put("message", "error").toString(),HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }

        return null;
    }

    @GetMapping(path = "/getAllBookings")
    public ResponseEntity<List<Booking>> getAllBookings() throws Exception {

        List<Booking> bookingList = bookingService.getAllBookings();
        if(bookingList.size() > 0){
            return new ResponseEntity<>(bookingList,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(path = "/getBookingById")
    public ResponseEntity<Booking> getBookingById(@RequestParam Integer id) throws Exception {

        Booking booking = bookingService.getBookingById(id);
        if(booking != null){
            return new ResponseEntity<>(booking,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping(path = "/deleteBooking")
    public ResponseEntity<String> deleteBooking(@RequestParam Integer id) throws Exception {

            Boolean bookingCheck = bookingService.deleteBooking(id);
            if(bookingCheck == true) {
                return new ResponseEntity<>(new JSONObject().put("message", "Booking Successfully Deleted").toString(),HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(new JSONObject().put("message", "error").toString(),HttpStatus.INTERNAL_SERVER_ERROR);
            }


    }

}
