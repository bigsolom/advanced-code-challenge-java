package com.statista.code.challenge.dal;

import com.statista.code.challenge.models.Booking;
import lombok.Setter;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookingsRepositoryInMemoryImpl implements BookingsRepository<Booking, Long> {
    @Setter
    //// TODO: 03.05.23 use set to ensure uniquenes of orders
    private List<Booking> bookings = new ArrayList<>();

    @Override
    public <S extends Booking> S save(S entity) {
        long id = entity.getBookingId();
        Optional existingBooking = findById(id);
        if(existingBooking.isPresent()){
            bookings = bookings.stream().map(b -> {
                if(b.getBookingId() == id){
                    b.setDescription(entity.getDescription());
                    b.setCurrency(entity.getCurrency());
                    b.setPrice(entity.getPrice());
                    b.setEmail(entity.getEmail());
                    b.setSubscriptionStartDate(entity.getSubscriptionStartDate());
                    b.setDepartment(entity.getDepartment());
                    return b;
                }
                return b;
            }).collect(Collectors.toList());
        } else {
            bookings.add(entity);
        }
        return entity;
    }

    @Override
    public Optional<Booking> findById(Long id) {
        return bookings.stream().filter(b -> b.getBookingId() == id).findAny();
    }

    @Override
    public List<Booking> findAll() {
        return bookings;
    }
}
