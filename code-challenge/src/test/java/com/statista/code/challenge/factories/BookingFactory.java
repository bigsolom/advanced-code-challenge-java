package com.statista.code.challenge.factories;

import com.statista.code.challenge.models.Booking;
import org.springframework.beans.factory.FactoryBean;

import java.awt.print.Book;
import java.util.Currency;

public class BookingFactory implements FactoryBean<Booking> {
    @Override
    public Booking getObject() throws Exception {
        Booking booking = new Booking();
        booking.setDescription("description");
        booking.setEmail("valid@email.com");
//        booking.setDepartment("valid department");
        booking.setCurrency(Currency.getInstance("EUR"));
        booking.setPrice(10.0d);
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
