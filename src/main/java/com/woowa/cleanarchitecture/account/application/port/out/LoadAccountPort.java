package com.woowa.cleanarchitecture.account.application.port.out;

import com.woowa.cleanarchitecture.account.domain.Account;

import java.time.LocalDateTime;

public interface LoadAccountPort {
    Account loadAccount(Long accountId, LocalDateTime baselineDate);
}
