package com.woowa.cleanarchitecture.account.application.port.out;

import com.woowa.cleanarchitecture.account.domain.AccountId;

public interface AccountLock {
    void lockAccount(AccountId accountId);

    void releaseAccount(AccountId accountId);
}
