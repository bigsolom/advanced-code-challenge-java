package com.statista.code.challenge.services;

import com.statista.code.challenge.dal.BookingsRepository;
import com.statista.code.challenge.models.Booking;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Currency;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookingsServiceTest {

    @Mock
    BookingsRepository bookingsRepository;

    @Mock
    NotificationsService notificationsService;

    @Mock
    BookingIDGeneratorService bookingIDGeneratorService;


    @InjectMocks
    BookingsService bookingsService;

    @Test
    void createBookingAssignsIdToBookingAndCreatesIt() throws Exception {
        Booking booking = new Booking();
        when(bookingsRepository.save(any(Booking.class))).thenReturn(booking);
//        when(bookingIDGeneratorService.nextID()).thenReturn(1L);

        Booking actual = bookingsService.createBooking(new Booking());

        assertThat(actual.getDescription()).isEqualTo(booking.getDescription());
        verify(bookingsRepository, times(1)).save(any(Booking.class));
        verify(notificationsService, times(1)).sendConfirmationEmail(any(Booking.class));
//        Booking createdBooking = bookingsService.createBooking(booking);
//        when()
    }

    private Booking newBooking(){
        Booking booking = new Booking();
        booking.setBookingId(1L);
        booking.setDescription("description");
        booking.setEmail("valid@email.com");
        booking.setDepartment("triathlon_department");
        booking.setCurrency(Currency.getInstance("EUR"));
        booking.setPrice(10.0d);
        return booking;
    }

}
