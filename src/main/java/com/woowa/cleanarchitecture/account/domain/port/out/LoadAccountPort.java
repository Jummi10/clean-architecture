package com.woowa.cleanarchitecture.account.domain.port.out;

import com.woowa.cleanarchitecture.account.application.Account;

import java.time.LocalDateTime;

public interface LoadAccountPort {
    Account loadAccount(Long accountId, LocalDateTime baselineDate);
}
