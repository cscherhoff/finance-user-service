package com.exxeta.userservice;


import com.exxeta.userservice.model.investment.Investment;
import com.exxeta.userservice.model.investment.Transaction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "investment-service")
public interface InvestmentServiceProxy {

    String depotPath = "/investments/user/{userId}";
    String investedPath = "/investments/user/{userId}";
    String profitPath = "/investments/user/{userId}";
    String transactionPath = "/investments/user/{userId}";

    @GetMapping(depotPath + "/depotEntries")
    String getAllDepotEntries(@PathVariable long userId);

    @GetMapping(depotPath + "/depotEntries/{depotName}")
    String getAllDepotEntriesForAGivenDepot(@PathVariable long userId, @PathVariable String depotName);

    @PostMapping(investedPath + "/invested")
    String postInvested(@PathVariable long userId, Investment investment);

    @GetMapping(investedPath + "/invested")
    String getInformations(@PathVariable long userId);

    @GetMapping(profitPath + "/profit")
    String getAllProfits(@PathVariable long userId);

    @PostMapping(transactionPath + "/transaction")
    String addNewTransaction(@PathVariable long userId, @RequestBody Transaction transaction);

    @GetMapping(transactionPath + "/transaction")
    String getAllTransactions(@PathVariable long userId);

    @GetMapping
    String getAllSecurities(@PathVariable long userId);
}
