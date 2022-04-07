package com.exxeta.userservice.controller.investment;

import com.exxeta.userservice.InvestmentServiceProxy;
import com.exxeta.userservice.config.CustomJwtAuthenticationFilter;
import com.exxeta.userservice.model.investment.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/investments/user/{userId}")
public class TransactionController {

    private final InvestmentServiceProxy investmentServiceProxy;
    private final CustomJwtAuthenticationFilter filter;

    public TransactionController(InvestmentServiceProxy investmentServiceProxy, CustomJwtAuthenticationFilter filter) {
        this.investmentServiceProxy = investmentServiceProxy;
        this.filter = filter;
    }

    @PostMapping(path = "/transaction")
    @ResponseStatus(HttpStatus.CREATED)
    public String addNewTransaction(@Valid @RequestBody Transaction transaction) {
        long userId = filter.getUserIdFromToken();
        return investmentServiceProxy.addNewTransaction(userId, transaction);
    }

}
