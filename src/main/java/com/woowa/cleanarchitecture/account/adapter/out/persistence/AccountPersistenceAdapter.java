package com.woowa.cleanarchitecture.account.adapter.out.persistence;

import com.woowa.cleanarchitecture.account.application.Account;
import com.woowa.cleanarchitecture.account.domain.port.out.LoadAccountPort;
import com.woowa.cleanarchitecture.account.domain.port.out.UpdateAccountStatePort;
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
