package com.woowa.cleanarchitecture.account.application.service;

import com.woowa.cleanarchitecture.account.application.port.in.SendMoneyUseCase;
import com.woowa.cleanarchitecture.account.application.port.out.LoadAccountPort;
import com.woowa.cleanarchitecture.account.application.port.out.UpdateAccountStatePort;
import com.woowa.cleanarchitecture.account.domain.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
@Transactional
public class SendMoneyService implements SendMoneyUseCase {
    private final LoadAccountPort loadAccountPort;
    private final UpdateAccountStatePort updateAccountStatePort;

    public void sendMoney(Long sourceAccountId, Long targetAccountId, Long amount) {
        Account sourceAccount = loadAccountPort.loadAccount(sourceAccountId, LocalDateTime.now());
        Account targetAccount = loadAccountPort.loadAccount(targetAccountId, LocalDateTime.now());

        updateAccountStatePort.updateActivities(sourceAccount);
        updateAccountStatePort.updateActivities(targetAccount);
    }
}
