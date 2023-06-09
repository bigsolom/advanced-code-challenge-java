package com.statista.code.challenge.dal;

import com.statista.code.challenge.models.Booking;
import com.statista.code.challenge.models.Department;
import com.statista.code.challenge.services.BookingIDGeneratorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Currency;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookingsRepositoryImplTest {

    private BookingsRepositoryImpl repository;

    @Mock
    private BookingIDGeneratorService idGeneratorService;

    @BeforeEach
    void setUp() throws Exception {
        repository = new BookingsRepositoryImpl();
    }

    @Test
    void findAll_givenThereAreExistingBookings_shouldReturnsThem() throws Exception {
        List<Booking> existing = Stream.of(new Booking(),new Booking()).collect(Collectors.toList());
        repository.setBookings(existing);
        List<Booking> result = repository.findAll();
        assertThat(result.size()).isEqualTo(existing.size());
    }

    @Test
    void save_givenNewBooking_shouldSaveIt() throws Exception {
        List<Booking> existing = Stream.of(new Booking()).collect(Collectors.toList());
        when(idGeneratorService.nextID()).thenReturn(1L);
        Booking booking = new Booking();
        booking.setBookingId(idGeneratorService.nextID());

        Booking savedBooking = repository.save(booking);
        assertThat(savedBooking.getBookingId()).isEqualTo(booking.getBookingId());
    }

    @Test
    void save_givenABookingWithExistingId_shouldReplaceTheExistingOne() throws Exception {
        Booking booking1 = new Booking();
//        when(idGeneratorService.nextID()).thenReturn(1L);
        booking1.setBookingId(1L);
        booking1.setDescription("old");
        Booking booking2 = new Booking();
        booking2.setBookingId(2L);
        booking2.setDescription("two");

        List<Booking> existingBookings = Stream.of(booking1, booking2).collect(Collectors.toList());
        repository.setBookings(existingBookings);

        String updatedDescription = "new";
        Booking toUpdate = Booking.builder().bookingId(1L).description(updatedDescription).currency(Currency.getInstance("USD")).email("valid@email.com").department(Department.TRIATHLON).build();
        
        Booking result = repository.save(toUpdate);

        assertEquals(updatedDescription, result.getDescription());
    }

    @Test
    void findById_givenExisitngBookingId_shouldReturnIt() throws Exception {
        Booking booking1 = new Booking();
        long queryId = 1L;
        booking1.setBookingId(queryId);

        Booking booking2 = new Booking();
        booking2.setBookingId(2L);

        repository.setBookings(Stream.of(booking1, booking2).collect(Collectors.toList()));

        Optional<Booking> result = repository.findById(queryId);

        assertTrue(result.isPresent());
        assertEquals(queryId, result.get().getBookingId());
    }
}
