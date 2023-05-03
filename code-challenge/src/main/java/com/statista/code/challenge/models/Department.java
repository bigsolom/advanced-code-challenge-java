package com.statista.code.challenge.models;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

public interface Department {
   String doBusiness();
   String getName();
}
