package com.exxeta.userservice.model.allocation;

import java.math.BigDecimal;

public class Category {

    private long CategoryId;

    private String categoryName;

    private BigDecimal budget;

    public Category() {
    }

    public String getCategoryName() {
        return categoryName;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }
}
