package com.jolly.dblab.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Currency;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Amount {
    BigDecimal value;
    Currency currencyCode;

    public static Amount of(int value, String code) {
        return new Amount(BigDecimal.valueOf(value), Currency.getInstance(code));
    }
}
