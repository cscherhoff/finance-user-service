package com.exxeta.userservice.controller.investment;

import com.exxeta.userservice.InvestmentServiceProxy;
import com.exxeta.userservice.config.CustomJwtAuthenticationFilter;
import com.exxeta.userservice.model.investment.TransactionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/investments/user/{userId}")
public class TransactionController {

    private final InvestmentServiceProxy investmentServiceProxy;
    private final CustomJwtAuthenticationFilter filter;

    private final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    public TransactionController(InvestmentServiceProxy investmentServiceProxy, CustomJwtAuthenticationFilter filter) {
        this.investmentServiceProxy = investmentServiceProxy;
        this.filter = filter;
    }

    @PostMapping(path = "/transaction")
    @ResponseStatus(HttpStatus.CREATED)
    public String addNewTransaction(@Valid @RequestBody TransactionDto transaction) {
        logger.info("Received transaction: " + transaction);
        long userId = filter.getUserIdFromToken();
        logger.info("Using user ID " + userId);
        return investmentServiceProxy.addNewTransaction(userId, transaction);
    }

    @GetMapping(path = "/transactions")
    public String getAllTransactions() {
        long userId = filter.getUserIdFromToken();
        logger.info("Getting all transactions for user ID " + userId);
        return investmentServiceProxy.getAllTransactions(userId);
    }
}
