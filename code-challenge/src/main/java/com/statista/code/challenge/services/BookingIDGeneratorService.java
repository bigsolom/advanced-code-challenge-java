package com.statista.code.challenge.services;

import cn.hutool.core.lang.Snowflake;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
//@Scope("singleton")
public class BookingIDGeneratorService {

    private Snowflake snowflake = new Snowflake();

    public Long nextID(){
        //// TODO: 02.05.23 better implementation/ open source alternative
        return snowflake.nextId();
    }
}
