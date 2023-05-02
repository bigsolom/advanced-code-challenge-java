package com.statista.code.challenge.dal;

import com.statista.code.challenge.models.Booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class BookingsRepositoryInMemoryImplTest {

    private BookingsRepositoryInMemoryImpl repository;

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
}
