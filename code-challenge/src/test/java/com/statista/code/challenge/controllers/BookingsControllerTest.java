package com.statista.code.challenge.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.statista.code.challenge.dal.BookingsRepository;
import com.statista.code.challenge.models.Booking;
import com.statista.code.challenge.services.BookingsService;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.Currency;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookingsController.class)
public class BookingsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookingsService bookingsService;

    @Test
    void createBooking_givenAValidBooking_shouldSaveAndReturnCreatedAndBooking() throws Exception {
        JSONObject body = new JSONObject();
        body.put("description", "Cool description;");
        body.put("price", 50.00);
        body.put("currency", "USD");
        body.put("subscription_start_date", 683124845000L);
        body.put("email", "valid@email.ok");
        body.put("department", "triatlon_department");
        when(bookingsService.create(any(Booking.class))).thenReturn(new Booking());
        MockHttpServletRequestBuilder request = post(String.format("/bookingservice/bookings"))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(body.toString());
        mockMvc.perform(request)
                .andExpect(status().isCreated());
    }
    @Test
    void getBookingById_givenAnExistingBookingId_returnsTheBooking() throws Exception {

    }

    @Test
    void getBookingById_givenNonExistingBookingId_ReturnsNotFound() throws Exception {

    }

}
