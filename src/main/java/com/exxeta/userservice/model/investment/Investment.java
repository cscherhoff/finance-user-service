package com.exxeta.userservice.model.investment;

import com.exxeta.userservice.util.LocalDateDeserializer;
import com.exxeta.userservice.util.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

public class Investment {

    @JsonIgnore
    public long investmentId;

    @JsonIgnore
    public long userId;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    public LocalDate date;

    @NotNull
    public double amount;

    public Investment() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Investment that = (Investment) o;
        return Double.compare(that.amount, amount) == 0 &&
            Objects.equals(date, that.date);
    }
}
