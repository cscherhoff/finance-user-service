package com.exxeta.userservice.controller.investment;

import com.exxeta.userservice.InvestmentServiceProxy;
import com.exxeta.userservice.config.CustomJwtAuthenticationFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/investments/user/{userId}")
public class DepotEntryController {

    private final InvestmentServiceProxy investmentServiceProxy;
    private final CustomJwtAuthenticationFilter filter;

    public DepotEntryController(InvestmentServiceProxy investmentServiceProxy, CustomJwtAuthenticationFilter filter) {
        this.investmentServiceProxy = investmentServiceProxy;
        this.filter = filter;
    }


    @GetMapping(path = "/depotEntries")
    public String getAllDepotEntries() {
        long userId = filter.getUserIdFromToken();
        return investmentServiceProxy.getAllDepotEntries(userId);
    }

    @GetMapping(path = "/depotEntries/{depotName}")
    public String getAllDepotEntriesForAGivenDepot(@PathVariable String depotName) {
        long userId = filter.getUserIdFromToken();
        return investmentServiceProxy.getAllDepotEntriesForAGivenDepot(userId, depotName);
    }
}
