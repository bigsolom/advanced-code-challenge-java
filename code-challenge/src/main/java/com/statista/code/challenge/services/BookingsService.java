package com.statista.code.challenge.services;

import com.statista.code.challenge.dal.BookingsRepository;
import com.statista.code.challenge.dal.DepartmentsRepository;
import com.statista.code.challenge.models.Booking;
import com.statista.code.challenge.models.Department;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BookingsService {

    @Autowired
    private BookingIDGeneratorService idGeneratorService;

    @Autowired
    private BookingsRepository bookingsRepository;

    @Autowired
    private DepartmentsRepository departmentsRepository;

    @Autowired
    private NotificationsService notificationsService;

    public Booking create(Booking booking){
        //Booking is already valid
        validateBooking(booking);
        booking.setBookingId(idGeneratorService.nextID());
        Booking result = bookingsRepository.save(booking);
        notificationsService.sendConfirmationEmail(result);
        return result;
    }

    public Optional<Booking> findById(long id){
        return bookingsRepository.findById(id);
    }

    public List<Booking> findByDepartment(String department){
        return bookingsRepository.findAll().stream().filter(b -> b.getDepartment().equals(department)).collect(Collectors.toList());
    }

    public List<Currency> getUsedCurrencies(){
        return bookingsRepository.findAll().stream().map(Booking::getCurrency).collect(Collectors.toList());
    }

    public double sumOfAllBookingsInCurrency(String currency){
        List<Double> bookingPrices = bookingsRepository.findAll().stream().filter(b -> b.getCurrency().getCurrencyCode().equals(currency.toUpperCase())).map(Booking::getPrice).collect(Collectors.toList());
        return bookingPrices.stream().reduce(0.0, Double::sum);
    }

    public Optional<String> doBusinessOFBooking(long bookingId){
        Optional<Booking> booking = bookingsRepository.findById(bookingId);
        if(!booking.isPresent()){
            return Optional.empty();
        }
        Optional<Department> department = departmentsRepository.findByName(booking.get().getDepartment());
        if(!department.isPresent()){
            return Optional.empty();
        }
        return Optional.of(department.get().doBusiness());
    }

    private void validateBooking(Booking booking){

    }
}
