package com.exxeta.userservice.model.investment;

import com.exxeta.userservice.util.LocalDateDeserializer;
import com.exxeta.userservice.util.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Transaction {

    @JsonIgnore
    private long transactionId;

    @JsonIgnore
    private long userId;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @NotNull
    private LocalDate date;
    @NotNull
    private String depotName;
    @NotNull
    private String type;
    @NotNull
    private String securityName;
    @NotNull
    private BigDecimal number;
    @NotNull
    private BigDecimal price;
    @NotNull
    private BigDecimal expenses;
    @NotNull
    private BigDecimal totalPrice;

    public Transaction() {

    }

    public Transaction(String depotName, LocalDate date, String type, String securityName,
                       BigDecimal price, BigDecimal number, BigDecimal expenses, BigDecimal totalPrice) {
        this.depotName = depotName;
        this.date = date;
        this.type = type;
        this.securityName = securityName;
        this.price = price;
        this.number = number;
        this.expenses = expenses;
        this.totalPrice = totalPrice;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getDepotName() {
        return depotName;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public String getSecurityName() {
        return securityName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getNumber() {
        return number;
    }

    public BigDecimal getExpenses() {
        return expenses;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Transaction{" +
            "transactionId=" + transactionId +
            ", userId=" + userId +
            ", depotName='" + depotName + '\'' +
            ", date=" + date +
            ", type='" + type + '\'' +
            ", securityName='" + securityName + '\'' +
            ", price=" + price +
            ", number=" + number +
            ", expenses=" + expenses +
            ", totalAmount=" + totalPrice +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Transaction that = (Transaction) o;
        return getUserId() == that.getUserId() &&
            Objects.equals(getDepotName(), that.getDepotName()) &&
            Objects.equals(getDate(), that.getDate()) &&
            Objects.equals(getType(), that.getType()) &&
            Objects.equals(getSecurityName(), that.getSecurityName()) &&
            Objects.equals(getPrice(), that.getPrice()) &&
            Objects.equals(getNumber(), that.getNumber()) &&
            Objects.equals(getExpenses(), that.getExpenses()) &&
            Objects.equals(getTotalPrice(), that.getTotalPrice());
    }
}
