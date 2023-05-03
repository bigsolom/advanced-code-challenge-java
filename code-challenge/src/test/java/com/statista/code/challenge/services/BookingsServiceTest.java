package com.statista.code.challenge.services;

import com.statista.code.challenge.dal.BookingsRepository;
import com.statista.code.challenge.factories.BookingFactory;
import com.statista.code.challenge.models.Booking;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.print.Book;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class BookingsServiceTest {

    @Mock
    BookingsRepository bookingsRepository;

    @Autowired
    BookingFactory bookingFactory;

    @InjectMocks
    BookingsService bookingsService;

    @Test
    void createBookingAssignsIdToBookingAndCreatesIt() throws Exception {
//        Booking booking = bookingFactory.getObject();
//        when(bookingsRepository.save(any(Booking.class))).thenReturn()
//        Booking createdBooking = bookingsService.createBooking(booking);
//        when()
    }

}
