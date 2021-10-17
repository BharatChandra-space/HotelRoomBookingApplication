package com.upgrad.BookingService.Service;

import com.upgrad.BookingService.Entity.Transaction;
import com.upgrad.BookingService.Entity.booking;
import com.upgrad.BookingService.dao.BookingDao;
import com.upgrad.BookingService.dto.BookingDTO;
import com.upgrad.BookingService.dto.TransactionDto;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.awt.print.Book;
import java.util.Optional;

@Service
public class BookingServiceimpl implements BookingService {
    @Autowired
    private BookingDao bookingDao;
    @Autowired
    private RestTemplate restTemplate;

    private BookingDTO bookingDTO;

    private Producer producer;

  //  Producer<String, String> producer;

   public BookingServiceimpl(BookingDao bookingDao,RestTemplate restTemplate, Producer<String, String> producer ){
       this.bookingDao = bookingDao;
       this.restTemplate = restTemplate;
       this.producer = producer;
   }

    @Override
    public booking acceptBookingDetails(booking Booking) {
        return bookingDao.save(Booking);
    }

    @Override
    public booking getBookingDetails(int id) {
        return bookingDao.getById(id);
    }

    public booking updatebookingDetails(int id, int transactionId) {

        // Booking booking = bookingDTO.get
        bookingDTO.setTransactionId(transactionId);
        //Booking.setTransactionId(id);
        return bookingDao.getById(id);
    }

    @Override
    public booking incurrpayment(int id, Transaction transaction) {

        String URL = "http://localhost:8081/transaction";
        System.out.println(id);
        Optional<booking> bookingcontract = Optional.of(bookingDao.getById(id));
        int transactionID = restTemplate.postForObject(URL, transaction, Integer.class);
        System.out.println("TransactionID= "+transactionID);
        if(bookingcontract.isPresent()){
            booking Booking = bookingcontract.get();
            System.out.println(bookingcontract);
            //int transactionID = restTemplate.postForObject(URL, transaction, Integer.class);
            Booking.setTransactionId(transactionID);
            bookingDao.save(Booking);
            String message = "Booked the room "+transactionID;
            producer.send(new ProducerRecord<>("bookingNotification","message",message));
            return Booking;
        }
        else {
            return null;
        }


    }
}
