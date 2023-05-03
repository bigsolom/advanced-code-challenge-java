package com.statista.code.challenge.controllers;
import com.statista.code.challenge.models.Booking;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.Currency;
import java.util.List;

@Controller
@RequestMapping("/bookingservice")
public class BookingsController {
    @PostMapping("/booking")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {

        return ResponseEntity.ok().build();
    }
    @PutMapping("/booking/{bookingId}")
    public ResponseEntity<Booking> updateBooking(@PathVariable("bookingId") long id, @RequestBody Booking booking) {

        return ResponseEntity.ok().build();
    }
    @GetMapping("/bookings/{bookingId}")
    public ResponseEntity getBookingById(@PathVariable("bookingId") long id) {

        return ResponseEntity.ok().build();
    }
    @GetMapping("/bookings/department/{department}")
    public ResponseEntity getBookingIdsOfDepartment(@PathVariable("department") String department) {
        return ResponseEntity.ok().build();
    }
    @GetMapping("/bookings/currencies")
    public ResponseEntity<List<Currency>> getCurrenciesOfExistingBookings() {
        return ResponseEntity.ok().build();
    }
    @GetMapping("/sum/{currency}")
    public ResponseEntity getSumBookingsPriceOfCurrency(@PathVariable("currency") String currency) {
        return ResponseEntity.ok().build();
    }
    @GetMapping("/bookings/dobusiness/{booking_id}")
    public ResponseEntity doBusinessOfBookingDepartment(@PathVariable("bookingId") long id) {
        return ResponseEntity.ok().build();
    }

}