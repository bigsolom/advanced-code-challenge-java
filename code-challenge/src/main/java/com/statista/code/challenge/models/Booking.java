package com.statista.code.challenge.models;


import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.util.Currency;
import java.util.Date;

//@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Booking {

//    @Autowired
//    private BookingIDGeneratorService idGeneratorService;

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

    @NonNull
    private String department;

    public Booking() {
    }
}
