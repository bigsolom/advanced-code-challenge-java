package com.statista.code.challenge.services;

import com.statista.code.challenge.dal.BookingsRepository;
import com.statista.code.challenge.models.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingsService {

    @Autowired
    private BookingIDGeneratorService idGeneratorService;

    @Autowired
    private BookingsRepository bookingsRepository;

    public Booking createBooking(Booking booking){
        //Booking is already valid
        booking.setBookingId(idGeneratorService.nextID());
        return bookingsRepository.save(booking);
    }
}
