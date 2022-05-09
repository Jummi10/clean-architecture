package com.woowa.cleanarchitecture.account.application.port.out;

import com.woowa.cleanarchitecture.account.domain.Account;
import com.woowa.cleanarchitecture.account.domain.AccountId;

import java.time.LocalDateTime;

public interface LoadAccountPort {
    Account loadAccount(AccountId accountId, LocalDateTime baselineDate);
}
