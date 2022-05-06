package com.woowa.cleanarchitecture.account;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final SendMoneyService sendMoneyService;

    @PostMapping("/send/{sourceAccountId}/{targetAccountId}/{amount}")
    public void sendMoney(@PathVariable Long sourceAccountId, @PathVariable Long targetAccountId, @PathVariable Long amount) {
        sendMoneyService.sendMoney(sourceAccountId, targetAccountId, amount);
    }
}
