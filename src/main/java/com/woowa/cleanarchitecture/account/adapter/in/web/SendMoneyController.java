package com.woowa.cleanarchitecture.account.adapter.in.web;

import com.woowa.cleanarchitecture.account.application.port.in.SendMoneyCommand;
import com.woowa.cleanarchitecture.account.application.port.in.SendMoneyUseCase;
import com.woowa.cleanarchitecture.account.domain.AccountId;
import com.woowa.cleanarchitecture.account.domain.Money;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RequiredArgsConstructor
@RestController
class SendMoneyController {
    private final SendMoneyUseCase sendMoneyUseCase;

    @PostMapping("/accounts/send/{sourceAccountId}/{targetAccountId}/{amount}")
    void sendMoney(@PathVariable Long sourceAccountId, @PathVariable Long targetAccountId, @PathVariable Long amount) {
        SendMoneyCommand sendMoneyCommand = new SendMoneyCommand(
                new AccountId(sourceAccountId),
                new AccountId(targetAccountId),
                Money.of(amount)
        );

        sendMoneyUseCase.sendMoney(sendMoneyCommand);
    }
}
