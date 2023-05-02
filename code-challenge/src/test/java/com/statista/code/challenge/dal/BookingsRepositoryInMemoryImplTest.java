package com.statista.code.challenge.dal;

import com.statista.code.challenge.models.Booking;
import com.statista.code.challenge.services.BookingIDGeneratorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.awt.print.Book;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookingsRepositoryInMemoryImplTest {

    private BookingsRepositoryInMemoryImpl repository;

    @Mock
    private BookingIDGeneratorService idGeneratorService;

    @BeforeEach
    void setUp() throws Exception {
        repository = new BookingsRepositoryInMemoryImpl();
    }

    @Test
    void findAllReturnsAllBookings() throws Exception {
        List<Booking> existing = Stream.of(new Booking(),new Booking()).collect(Collectors.toList());
        repository.setBookings(existing);
        List<Booking> result = repository.findAll();
        assertThat(result.size()).isEqualTo(existing.size());
    }

    @Test
    void saveAddsNewBooking() throws Exception {
        List<Booking> existing = Stream.of(new Booking()).collect(Collectors.toList());
        when(idGeneratorService.nextID()).thenReturn(1L);
        Booking booking = new Booking();
        booking.setBookingId(idGeneratorService.nextID());

        Booking savedBooking = repository.save(booking);
        assertThat(savedBooking.getBookingId()).isEqualTo(booking.getBookingId());
    }

    @Test
    void saveUpdatesExistingBooking() throws Exception {
        Booking booking1 = new Booking();
//        when(idGeneratorService.nextID()).thenReturn(1L);
        booking1.setBookingId(1L);
        booking1.setDescription("old");
        Booking booking2 = new Booking();
        booking2.setBookingId(2L);
        booking2.setDescription("two");

        List<Booking> existingBookings = Stream.of(booking1, booking2).collect(Collectors.toList());
        repository.setBookings(existingBookings);

        Booking toUpdate = new Booking();
        toUpdate.setBookingId(1L);
        String updatedDescription = "new";
        toUpdate.setDescription(updatedDescription);

        Booking result = repository.save(toUpdate);

        assertEquals(updatedDescription, result.getDescription());
    }
}
