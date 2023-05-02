package com.statista.code.challenge.services;

import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class BookingIDGeneratorService {

    private long sequence = 0L;

    public Long nextID(){
        //// TODO: 02.05.23 better implementation/ open source alternative
        return Instant.now().toEpochMilli();
    }
}
