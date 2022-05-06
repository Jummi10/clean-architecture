package com.woowa.cleanarchitecture.web;

import com.woowa.cleanarchitecture.domain.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/send/{sourceAccountId}/{targetAccountId}/{amount}")
    public void sendMoney(@PathVariable Long sourceAccountId, @PathVariable Long targetAccountId, @PathVariable Long amount) {
        accountService.sendMoney(sourceAccountId, targetAccountId, amount);
    }
}
