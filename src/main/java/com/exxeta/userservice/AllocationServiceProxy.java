package com.exxeta.userservice;


import com.exxeta.userservice.model.allocation.Allocation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;

@FeignClient(name = "allocator-service")
public interface AllocationServiceProxy {

    String allocationPath = "/allocation/user/{userId}";
    String incomePath = "/income/user/{userId}";

    @GetMapping(allocationPath)
    String getAllocation(@PathVariable long userId);

    @PutMapping(allocationPath)
    void updateAllocation(@PathVariable long userId, @RequestBody Allocation allocation);

    @GetMapping(incomePath)
    String getIncome(@PathVariable long userId);

    @PutMapping(incomePath)
    void updateIncome(@PathVariable long userId, @RequestBody BigDecimal income);
}
