package com.statista.code.challenge.services;

import com.statista.code.challenge.models.Booking;
import org.springframework.stereotype.Service;

@Service
public class NotificationsService {
    public boolean sendConfirmationEmail(Booking booking){
        //gets data from booking, sends an email, returns true for success
        return true;
    }
}
