package com.woowa.cleanarchitecture.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class AccountService {
    private final AccountRepository accountRepository;

    public void sendMoney(Long sourceAccountId, Long targetAccountId, Long amount) {
        Account account = new Account();

        accountRepository.lockAccount(sourceAccountId);
        accountRepository.lockAccount(targetAccountId);

        accountRepository.releaseAccount(sourceAccountId);
        accountRepository.releaseAccount(targetAccountId);
    }
}
