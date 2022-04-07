package com.exxeta.userservice.controller.expense;

import com.exxeta.userservice.ExpenseServiceProxy;
import com.exxeta.userservice.config.CustomJwtAuthenticationFilter;
import com.exxeta.userservice.model.expense.ExpenseFromFrontend;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController()
@RequestMapping(path = "/expense/user/{userId}")
public class ExpenseController {

    private final ExpenseServiceProxy proxy;
    private final CustomJwtAuthenticationFilter filter;

    public ExpenseController(ExpenseServiceProxy proxy,
                             CustomJwtAuthenticationFilter filter) {this.proxy = proxy;
        this.filter = filter;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/accountName/{accountName}")
    public String postNewExpenses(@PathVariable String accountName,
                                 @RequestBody List<ExpenseFromFrontend> expensesFromFrontend) throws IOException {
        long userId = filter.getUserIdFromToken();
        return proxy.postNewExpenses(userId, accountName, expensesFromFrontend);
    }

    @GetMapping
    public String getAllExpenses() {
        long userId = filter.getUserIdFromToken();
        return proxy.getAllExpenses(userId);
    }
}
