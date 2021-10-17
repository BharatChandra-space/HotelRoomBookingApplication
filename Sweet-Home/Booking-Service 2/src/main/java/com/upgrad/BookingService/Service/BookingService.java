package com.upgrad.BookingService.Service;

import com.upgrad.BookingService.Entity.Transaction;
import com.upgrad.BookingService.Entity.booking;
import com.upgrad.BookingService.dto.TransactionDto;

public interface BookingService {
    public booking acceptBookingDetails(booking Booking);
    public booking getBookingDetails(int id);
    public booking updatebookingDetails(int id,int transactionId);
    public booking incurrpayment(int id ,Transaction transaction);
}
