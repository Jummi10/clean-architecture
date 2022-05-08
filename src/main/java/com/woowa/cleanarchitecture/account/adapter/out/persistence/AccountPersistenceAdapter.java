package com.woowa.cleanarchitecture.account.adapter.out.persistence;

import com.woowa.cleanarchitecture.account.application.port.out.LoadAccountPort;
import com.woowa.cleanarchitecture.account.application.port.out.UpdateAccountStatePort;
import com.woowa.cleanarchitecture.account.domain.Account;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
class AccountPersistenceAdapter implements LoadAccountPort, UpdateAccountStatePort {
    private final SpringDataAccountRepository accountRepository;

    @Override
    public Account loadAccount(Long accountId, LocalDateTime baselineDate) {
        System.out.println("load account id " + accountId);
        return new Account(accountId, 10000L);
    }

    @Override
    public void updateActivities(Account account) {
        System.out.println("update account id " + account.getId() + " activities");
    }
}
