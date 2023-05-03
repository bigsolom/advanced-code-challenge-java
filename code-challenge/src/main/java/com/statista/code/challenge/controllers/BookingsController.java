package com.statista.code.challenge.controllers;

import com.statista.code.challenge.models.Booking;
import com.statista.code.challenge.services.BookingsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Currency;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/bookingservice")
public class BookingsController {

    @Autowired
    private BookingsService bookingsService;

    @PostMapping("/bookings")
    public ResponseEntity<Booking> createBooking(@Valid @RequestBody Booking booking) {
        Booking result = bookingsService.create(booking);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PutMapping("/booking/{bookingId}")
    public ResponseEntity<Booking> updateBooking(@PathVariable("bookingId") long id, @RequestBody Booking booking) {

        return ResponseEntity.ok().build();
    }
    @GetMapping("/bookings/{bookingId}")
    public ResponseEntity getBookingById(@PathVariable("bookingId") long id) {
        Optional<Booking> result = bookingsService.findById(id);
        if(result.isPresent()){
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
//        return ResponseEntity.ok().build();
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