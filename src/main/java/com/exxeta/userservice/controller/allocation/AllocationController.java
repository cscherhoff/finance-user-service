package com.exxeta.userservice.controller.allocation;

import com.exxeta.userservice.AllocationServiceProxy;
import com.exxeta.userservice.config.CustomJwtAuthenticationFilter;
import com.exxeta.userservice.model.allocation.Allocation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/allocation/user/{userId}")
public class AllocationController {

    private final AllocationServiceProxy proxy;
    private final CustomJwtAuthenticationFilter filter;

    public AllocationController(AllocationServiceProxy proxy,
                             CustomJwtAuthenticationFilter filter) {
        this.proxy = proxy;
        this.filter = filter;
    }

    @GetMapping
    public String getAllocation() {
        long userId = filter.getUserIdFromToken();
        return proxy.getAllocation(userId);
    }

    @PutMapping
    public void updateAllocation(@RequestBody Allocation allocation) {
        long userId = filter.getUserIdFromToken();
        proxy.updateAllocation(userId, allocation);
    }
}
