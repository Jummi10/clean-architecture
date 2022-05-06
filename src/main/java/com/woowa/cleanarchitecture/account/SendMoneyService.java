package com.woowa.cleanarchitecture.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class SendMoneyService {
    private final AccountRepository accountRepository;

    public void sendMoney(Long sourceAccountId, Long targetAccountId, Long amount) {
        Account account = new Account("clean", amount);

        accountRepository.lockAccount(sourceAccountId);
        accountRepository.lockAccount(targetAccountId);

        accountRepository.releaseAccount(sourceAccountId);
        accountRepository.releaseAccount(targetAccountId);
    }
}
