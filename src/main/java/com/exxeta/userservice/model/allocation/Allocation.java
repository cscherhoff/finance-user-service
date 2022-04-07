package com.exxeta.userservice.model.allocation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Allocation {

    private long userId;

    private BigDecimal investment;

    private List<FixCost> fixCosts = new ArrayList<>();

    private List<Category> categories = new ArrayList<>();

    public Allocation() {
        investment = BigDecimal.ZERO;
    }

    public Allocation(long userId) {
        this();
        this.userId = userId;
    }

    public Allocation(long userId, BigDecimal investment) {
        this.userId = userId;
        this.investment = investment;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public BigDecimal getInvestment() {
        return investment;
    }

    public List<FixCost> getFixCosts() {
        return fixCosts;
    }

    public List<Category> getCategories() {
        return categories;
    }

}
