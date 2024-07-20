package com.jolly.dblab.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumber {
    String number;
    @Enumerated(EnumType.STRING) Type type;

    public enum Type {
        HOME, WORK,
        ;
    }
}
