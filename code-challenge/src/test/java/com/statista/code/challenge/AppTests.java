package com.statista.code.challenge;

import com.statista.code.challenge.controllers.BookingsController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@AutoConfigureMockMvc
public class AppTests {

    @Autowired
    private BookingsController bookingsController;
    @Test
    void contextLoads() {
        assertThat(bookingsController).isNotNull();
    }
}
