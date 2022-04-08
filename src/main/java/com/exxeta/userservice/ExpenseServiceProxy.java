package com.exxeta.userservice;


import com.exxeta.userservice.model.expense.ExpenseFromFrontend;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "expense-service")
public interface ExpenseServiceProxy {

    String expensePath = "/expense/user/{userId}";
    String categoriePath = "/categories/user/{userId}";

    @PostMapping(expensePath + "/accountName/{accountName}")
    String postNewExpenses(@PathVariable long userId, @PathVariable String accountName,
                           @RequestBody List<ExpenseFromFrontend> expensesFromFrontend);

    @GetMapping(expensePath)
    String getAllExpenses(@PathVariable long userId);

    @GetMapping(categoriePath)
    String getAllCategories(@PathVariable long userId);

}
