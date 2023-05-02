package com.statista.code.challenge.dal;

import com.statista.code.challenge.models.Booking;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookingsRepositoryInMemoryImpl implements BookingsRepository<Booking, Long> {
    @Setter
    private List<Booking> bookings = new ArrayList<>();

    @Override
    public <S extends Booking> S save(S entity) {
        return null;
    }

    @Override
    public Optional<Booking> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<Booking> findAll() {
        return bookings;
    }
}
