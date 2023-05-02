package com.statista.code.challenge.models;

import com.statista.code.challenge.services.BookingIDGeneratorService;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

import java.util.Currency;
import java.util.Date;

//@Entity
@Getter
@Setter
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

    public Booking() {
    }
}
