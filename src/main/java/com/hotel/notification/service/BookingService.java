package com.hotel.notification.service;

import com.hotel.notification.model.*;
import com.hotel.notification.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

@Service
@EnableAsync
@EnableScheduling
public class BookingService {

    @Autowired
    RoomTypeRepo roomTypeRepo;

    @Autowired
    RoomRepo roomRepo;

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    BookingRoomRepo bookingRoomRepo;

    @Autowired
    BookingAdditionalServicesRepo bookingAdditionalServicesRepo;

      public Boolean addBooking(@RequestBody Booking booking){

          List<Integer> roomStatusUpdate = new ArrayList<>();

         if(booking.getBookingRooms().size() > 0){

             Integer bookingRoomSize = booking.getBookingRooms().size();
             List<BookingRoom> bookingRoomList = new ArrayList<>();

             for(int i=0;i<bookingRoomSize;i++){

               List<Room> roomList = roomRepo.getRoomsByRoomId(booking.getBookingRooms().get(i).getBookingType(), booking.getBookingRooms().get(i).getRoomId());

               if(roomList.size() > 0){
                   for (Room rm:roomList) {
                       BookingRoom bookingRoom = new BookingRoom();
                       bookingRoom.setBookingType(rm.getRoomType().getId());
                       bookingRoom.setRoomId(rm.getId());
                       bookingRoomList.add(bookingRoom);
                       roomStatusUpdate.add(rm.getId());
                   }
               }

             }
             booking.setBookingRooms(bookingRoomList);
         }

         Booking booking1 = bookingRepo.save(booking);

         if(booking1 != null){

             roomRepo.updateRoomStatus(true,roomStatusUpdate);

             return true;
         }
         else{
             return false;
         }


      }

    public  List <Booking> getAllBookings(){

        if (bookingRepo.findAll() != null) {
            return bookingRepo.findAll();
        } else {
            return null;
        }
    }

    public Booking getBookingById(Integer id){

        if (bookingRepo.findById(id) != null) {
            return bookingRepo.findById(id).get();
        } else {
            return null;
        }
    }

    public Boolean deleteBooking(@RequestBody Integer id){

        Booking booking = bookingRepo.findById(id).get();

        if(booking.getStartDate().compareTo(new Date()) <= 0){
            return false;
        }

        if(booking != null){
        if(booking.getBookingRooms().size() > 0){

            List<Integer> roomId = booking.getBookingRooms().stream()
                    .map(BookingRoom::getRoomId) // Extract the ID of each person
                    .distinct()          // Remove duplicates
                    .collect(Collectors.toList());

           roomRepo.updateRoomStatus(false,roomId);

        }

       bookingRepo.deleteById(id) ;


            return true;
        }
        else{
            return false;
        }


    }

    public Boolean updateBooking(@RequestBody Integer id , @RequestBody Booking booking){

        if(booking.getStartDate().compareTo(new Date()) <= 0){
            return false;
        }

        List<Integer> roomStatusUpdate = new ArrayList<>();

        Booking bookingId = bookingRepo.findById(id).get();

        if(bookingId != null){
            if(bookingId.getBookingRooms().size() > 0){

                List<Integer> roomId = bookingId.getBookingRooms().stream()
                        .map(BookingRoom::getRoomId) // Extract the ID of each person
                        .distinct()          // Remove duplicates
                        .collect(Collectors.toList());

                roomRepo.updateRoomStatus(false,roomId);

            }
        }

        if(booking.getBookingRooms().size() > 0){

            Integer bookingRoomSize = booking.getBookingRooms().size();
            List<BookingRoom> bookingRoomList = new ArrayList<>();

            for(int i=0;i<bookingRoomSize;i++){

                List<Room> roomList = roomRepo.getRoomsByRoomId(booking.getBookingRooms().get(i).getBookingType(), booking.getBookingRooms().get(i).getRoomId());

                if(roomList.size() > 0){
                    for (Room rm:roomList) {
                        BookingRoom bookingRoom = new BookingRoom();
                        bookingRoom.setBookingType(rm.getRoomType().getId());
                        bookingRoom.setRoomId(rm.getId());
                        bookingRoomList.add(bookingRoom);
                        roomStatusUpdate.add(rm.getId());
                    }
                }

            }
            booking.setBookingRooms(bookingRoomList);
        }

        booking.setId(id);
        booking.setCreatedAt(bookingId.getCreatedAt());
        Booking booking1 = bookingRepo.save(booking);

        if(booking1 != null){

            roomRepo.updateRoomStatus(true,roomStatusUpdate);

            List<BookingRoom> bookingRoom = bookingRoomRepo.getRoomNull();
            List<BookingAdditionalServices> bookingAdditionalServices = bookingAdditionalServicesRepo.getServicesNull();

            if(bookingRoom.size() > 0){
                bookingRoomRepo.deleteAll(bookingRoom);
            }
            if(bookingAdditionalServices.size() > 0){
                bookingAdditionalServicesRepo.deleteAll(bookingAdditionalServices);
            }

            return true;
        }
        else{
            return false;
        }


    }

//      @Async
//    @Scheduled(fixedRate = 10000)
    public String getData(){

          List<RoomType> roomTypeList = roomTypeRepo.findAll();
          List<Room> roomList = new ArrayList<>();

          for (RoomType rt:roomTypeList) {

              for (int i=1;i<=20;i++) {
                  Room room = new Room();
                  room.setAvailable(false);

                  room.setRoomType(rt);
                  room.setRoomCapacity(20);
                  if(Objects.equals(rt.getRoomType(), "Single")){
                      room.setRoomNumber("S"+i);
                      room.setPrice(20f);
                  }
                  if(Objects.equals(rt.getRoomType(), "Double")){
                      room.setRoomNumber("D"+i);
                      room.setPrice(40f);
                  }
                  if(Objects.equals(rt.getRoomType(), "Suite")){
                      room.setRoomNumber("SU"+i);
                      room.setPrice(50f);
                  }

                  roomList.add(room);

              }
          }

          roomRepo.saveAll(roomList);

          return null;
      }

}
