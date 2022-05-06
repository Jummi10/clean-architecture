package com.woowa.cleanarchitecture.account.adapter.in.web;

import com.woowa.cleanarchitecture.account.domain.port.in.SendMoneyUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/accounts")
class AccountController {
    private final SendMoneyUseCase sendMoneyUseCase;

    @PostMapping("/send/{sourceAccountId}/{targetAccountId}/{amount}")
    void sendMoney(@PathVariable Long sourceAccountId, @PathVariable Long targetAccountId, @PathVariable Long amount) {
        sendMoneyUseCase.sendMoney(sourceAccountId, targetAccountId, amount);
    }
}
