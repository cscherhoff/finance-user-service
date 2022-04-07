package com.exxeta.userservice.controller.investment;

import com.exxeta.userservice.InvestmentServiceProxy;
import com.exxeta.userservice.config.CustomJwtAuthenticationFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/investments/user/{userId}")
public class ProfitController {

    private final InvestmentServiceProxy investmentServiceProxy;
    private final CustomJwtAuthenticationFilter filter;

    public ProfitController(InvestmentServiceProxy investmentServiceProxy, CustomJwtAuthenticationFilter filter) {
        this.investmentServiceProxy = investmentServiceProxy;
        this.filter = filter;
    }

    @GetMapping(path = "/profit")
    public String getAllProfits() {
        long userId = filter.getUserIdFromToken();
        return investmentServiceProxy.getAllProfits(userId);
    }
}
