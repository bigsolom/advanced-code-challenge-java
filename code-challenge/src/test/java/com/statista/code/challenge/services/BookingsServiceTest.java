package com.statista.code.challenge.services;

import com.statista.code.challenge.dal.BookingsRepository;
import com.statista.code.challenge.models.Booking;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Currency;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        Booking booking = newBooking();
        when(bookingsRepository.save(any(Booking.class))).thenReturn(booking);
//        when(bookingIDGeneratorService.nextID()).thenReturn(1L);

        Booking actual = bookingsService.create(new Booking());

        assertThat(actual.getDescription()).isEqualTo(booking.getDescription());
        verify(bookingsRepository, times(1)).save(any(Booking.class));
        verify(notificationsService, times(1)).sendConfirmationEmail(any(Booking.class));
//        Booking createdBooking = bookingsService.createBooking(booking);
//        when()
    }

    @Test
    void findBookingByIdRetursBookingWhenFound() throws Exception {
        long queryId = 1L;
        Booking booking1 = new Booking();
        booking1.setBookingId(queryId);
        Booking booking2 = new Booking();
        booking2.setBookingId(2L);
        when(bookingsRepository.findAll()).thenReturn(Stream.of(booking1, booking2).collect(Collectors.toList()));

        Optional<Booking> result = bookingsService.findById(queryId);
        assertThat(result).isNotEmpty();
        assertThat(result.get().getBookingId()).isEqualTo(queryId);
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
