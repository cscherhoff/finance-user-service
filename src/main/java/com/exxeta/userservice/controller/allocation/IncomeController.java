package com.exxeta.userservice.controller.allocation;

import com.exxeta.userservice.AllocationServiceProxy;
import com.exxeta.userservice.config.CustomJwtAuthenticationFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(path = "/income/user/{userId}")
public class IncomeController {

    private final AllocationServiceProxy allocationServiceProxy;
    private final CustomJwtAuthenticationFilter filter;

    public IncomeController(AllocationServiceProxy allocationServiceProxy, CustomJwtAuthenticationFilter filter) {
        this.allocationServiceProxy = allocationServiceProxy;
        this.filter = filter;
    }

    @GetMapping
    public String getIncome() {
        long userId = filter.getUserIdFromToken();
        return allocationServiceProxy.getIncome(userId);
    }

    @PutMapping
    public void updateIncome(@RequestBody BigDecimal income) {
        long userId = filter.getUserIdFromToken();
        allocationServiceProxy.updateIncome(userId, income);
    }
}
