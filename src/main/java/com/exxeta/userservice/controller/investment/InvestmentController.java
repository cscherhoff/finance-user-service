package com.exxeta.userservice.controller.investment;

import com.exxeta.userservice.InvestmentServiceProxy;
import com.exxeta.userservice.config.CustomJwtAuthenticationFilter;
import com.exxeta.userservice.model.investment.Investment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/investments/user/{userId}")
public class InvestmentController {

    private final InvestmentServiceProxy investmentServiceProxy;
    private final CustomJwtAuthenticationFilter filter;

    public InvestmentController(InvestmentServiceProxy investmentServiceProxy, CustomJwtAuthenticationFilter filter) {
        this.investmentServiceProxy = investmentServiceProxy;
        this.filter = filter;
    }

    @PostMapping(path = "/invested")
    @ResponseStatus(HttpStatus.CREATED)
    public String postInvested(@Valid @RequestBody Investment investment) {
        long userId = filter.getUserIdFromToken();
        return investmentServiceProxy.postInvested(userId, investment);
    }

    @GetMapping(path = "/invested")
    public String getInformations() {
        long userId = filter.getUserIdFromToken();
        return investmentServiceProxy.getInformations(userId);
    }
}
