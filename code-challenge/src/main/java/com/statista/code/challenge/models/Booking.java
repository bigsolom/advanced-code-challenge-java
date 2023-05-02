package com.statista.code.challenge.models;

import jakarta.validation.constraints.Email;
import org.springframework.lang.NonNull;

import java.util.Currency;
import java.util.Date;

//@Entity
public class Booking {
    private Long bookingId;

    private String description;

    @NonNull
    private double price;

    @NonNull
    private Currency currency;

    @NonNull
    @Email(message = "Invalid Email Format")
    private String email;

    private Date subscriptionStartDate;
    private Department department;
}
