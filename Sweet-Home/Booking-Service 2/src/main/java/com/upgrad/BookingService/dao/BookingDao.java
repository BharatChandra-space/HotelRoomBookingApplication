package com.upgrad.BookingService.dao;

import com.upgrad.BookingService.Entity.booking;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * This Layer wil be used to talk to the Databases
 */


public interface BookingDao extends JpaRepository<booking,Integer> {
}
