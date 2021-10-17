package com.upgrad.BookingService.controller;


import com.upgrad.BookingService.Entity.Transaction;
import com.upgrad.BookingService.Entity.booking;
import com.upgrad.BookingService.Service.BookingService;
import com.upgrad.BookingService.dao.BookingDao;
import com.upgrad.BookingService.dto.BookingDTO;
import com.upgrad.BookingService.dto.TransactionDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.text.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.upgrad.BookingService.util.roomNumbers.getRandomNumbers;

@RestController
@RequestMapping(value = "/booking")
public class BookingserviceController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    BookingDao bookingDao;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createBooking(@RequestBody BookingDTO bookingDTO) throws ParseException {

        booking newbooking = modelMapper.map(bookingDTO,booking.class);
        newbooking.setBookedOn(LocalDateTime.now());
        Date date1=  new SimpleDateFormat("yyyy-MM-dd").parse(bookingDTO.getFromDate());
        Date date2=  new SimpleDateFormat("yyyy-MM-dd").parse(bookingDTO.getToDate());
        long diffInMillies = Math.abs(date1.getTime() - date2.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        newbooking.setRoomPrice((int) (diff*bookingDTO.getNumOfRooms()*1000));
        newbooking.setRoomNumbers(String.valueOf(getRandomNumbers(bookingDTO.getNumOfRooms())));
        booking savedbooking = bookingService.acceptBookingDetails(newbooking);
        BookingDTO savedbookingDTO = modelMapper.map(savedbooking,BookingDTO.class);
        return new ResponseEntity(savedbookingDTO, HttpStatus.CREATED);

    }
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getBooking(@PathVariable(name ="id" ) int id) {
            booking responsebooking = bookingService.getBookingDetails(id);
        BookingDTO responsebookingdto = modelMapper.map(responsebooking, BookingDTO.class);
            return new ResponseEntity(responsebookingdto, HttpStatus.OK);
    }

    @PostMapping(value = "/{id}/transaction",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity ConfirmBooking(@RequestBody @PathVariable(name = "id") int id,@RequestBody TransactionDto TransactionDetails){

        Transaction transaction = modelMapper.map(TransactionDetails,Transaction.class);
        System.out.println(transaction.getTransactionId());
        booking confirmedbooking = bookingService.incurrpayment(id, transaction);
        BookingDTO ConfirmedBookingDTO = modelMapper.map(confirmedbooking, BookingDTO.class);
        return new ResponseEntity(ConfirmedBookingDTO,HttpStatus.OK);

    }

}
