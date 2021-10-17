package com.upgrad.BookingService.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.upgrad.BookingService.dao.BookingDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.type.LocalDateTimeType;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookingId;
    private String fromDate;
    private String toDate;

    private String aadharNumber;
    private int numOfRooms;
    private String roomNumbers;
    private int roomPrice;
    private int transactionId;
    @Column(nullable = false)
    private LocalDateTime bookedOn;
}
