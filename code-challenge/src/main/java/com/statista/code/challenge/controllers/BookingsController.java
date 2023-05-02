package com.statista.code.challenge.controllers;
import com.statista.code.challenge.models.Booking;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Currency;
import java.util.List;

@Controller
@RequestMapping("/bookingservice")
public class BookingsController {
    @PostMapping("/booking")
    public ResponseEntity<Booking> createBooking() {
        return ResponseEntity.ok().build();
    }
    @PutMapping("/booking/{bookingId}")
    public ResponseEntity<Booking> updateBooking() {
        return ResponseEntity.ok().build();
    }
    @GetMapping("/bookings/{bookingId}")
    public ResponseEntity getBookingById() {
        return ResponseEntity.ok().build();
    }
    @GetMapping("/bookings/department/{department}")
    public ResponseEntity getBookingIdsOfDepartment() {
        return ResponseEntity.ok().build();
    }
    @GetMapping("/bookings/currencies")
    public ResponseEntity<List<Currency>> getCurrenciesOfExistingBookings() {
        return ResponseEntity.ok().build();
    }
    @GetMapping("/sum/{currency}")
    public ResponseEntity getSumBookingsPriceOfCurrency() {
        return ResponseEntity.ok().build();
    }
    @GetMapping("/bookings/dobusiness/{booking_id}")
    public ResponseEntity doBusinessOfBookingDepartment() {
        return ResponseEntity.ok().build();
    }

}