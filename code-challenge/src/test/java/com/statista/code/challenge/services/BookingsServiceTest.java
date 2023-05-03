package com.statista.code.challenge.services;

import com.statista.code.challenge.dal.BookingsRepository;
import com.statista.code.challenge.models.Booking;
import com.statista.code.challenge.models.Department;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Currency;
import java.util.List;
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
    void create_givenValidBooking_shouldSaveIt() throws Exception {
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
    void findById_givenExistingBookingId_shouldReturnTheBooking() throws Exception {
        long queryId = 1L;
        Booking booking1 = new Booking();
        booking1.setBookingId(queryId);

        when(bookingsRepository.findById(queryId)).thenReturn(Optional.of(booking1));

        Optional<Booking> result = bookingsService.findById(queryId);
        assertThat(result).isNotEmpty();
        assertThat(result.get().getBookingId()).isEqualTo(queryId);
    }

    @Test
    void findByDepartment_givenAnExisitingDepartment_shouldReturnAllBookingsWithinTheDepartment() throws Exception {
        String query = Department.TRIATHLON;
        Booking booking1 = newBookingOfDepartment(query);
        Booking booking2 = newBookingOfDepartment(query);
        Booking booking3 = newBookingOfDepartment(Department.CROSSFIT);

        when(bookingsRepository.findAll()).thenReturn(Stream.of(booking1, booking2, booking3).collect(Collectors.toList()));

        List<Booking> result = bookingsService.findByDepartment(query);
        assertThat(result).contains(booking1,booking2);
        assertThat(result).doesNotContain(booking3);
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

    private Booking newBookingOfDepartment(String department){
        return Booking.builder().department(department).currency(Currency.getInstance("USD")).email("valid@email.com").price(0D).build();
    }

    private Booking newBookingOfCurrency(String currency){
        return Booking.builder().department(Department.TRIATHLON).currency(Currency.getInstance(currency.toUpperCase())).email("valid@email.com").price(0D).build();
    }

}
