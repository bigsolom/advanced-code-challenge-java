package com.statista.code.challenge.controllers;

import com.statista.code.challenge.dal.BookingsRepository;
import com.statista.code.challenge.models.Booking;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(BookingsController.class)
public class BookingsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookingsRepository repository;

    @Test
    void createBookingAssignsIdAndReturnsTheBookingCreated() throws Exception {

    }
    @Test
    void getBookingByIdReturnsBookingWhenFound() throws Exception {

    }

    @Test
    void getBookingByIdReturnsNotFoundIfIdDoesnotExist() throws Exception {

    }

}
