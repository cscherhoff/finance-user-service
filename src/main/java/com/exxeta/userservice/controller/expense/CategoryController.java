package com.exxeta.userservice.controller.expense;

import com.exxeta.userservice.ExpenseServiceProxy;
import com.exxeta.userservice.config.CustomJwtAuthenticationFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path = "/categories/user/{userId}")
public class CategoryController {

    private final ExpenseServiceProxy proxy;
    private final CustomJwtAuthenticationFilter filter;

    public CategoryController(ExpenseServiceProxy proxy,
                             CustomJwtAuthenticationFilter filter) {
        this.proxy = proxy;
        this.filter = filter;
    }
    @GetMapping
    public String getAllCategories() {
        long userId = filter.getUserIdFromToken();
        return proxy.getAllCategories(userId);
    }
}
