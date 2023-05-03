package com.statista.code.challenge.services;

import com.statista.code.challenge.dal.BookingsRepository;
import com.statista.code.challenge.models.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingsService {

    @Autowired
    private BookingIDGeneratorService idGeneratorService;

    @Autowired
    private BookingsRepository bookingsRepository;

    @Autowired
    private NotificationsService notificationsService;

    public Booking create(Booking booking){
        //Booking is already valid
        booking.setBookingId(idGeneratorService.nextID());
        Booking result = bookingsRepository.save(booking);
        notificationsService.sendConfirmationEmail(result);
        return result;
    }

    public Optional<Booking> findById(long id){
        return bookingsRepository.findById(id);
    }
}
