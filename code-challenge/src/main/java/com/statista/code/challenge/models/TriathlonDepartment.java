package com.statista.code.challenge.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class TriathlonDepartment implements Department{
    @Getter
    @Setter
    @NonNull
    private String name;
    @Override
    public String doBusiness() {
        return "Hello from Trainings!";
    }
}
