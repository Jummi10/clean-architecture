package com.woowa.cleanarchitecture.account.adapter.out.persistence;

import com.woowa.cleanarchitecture.account.application.port.out.AccountLock;
import com.woowa.cleanarchitecture.account.domain.AccountId;
import org.springframework.stereotype.Component;

@Component
class NoOpAccountLock implements AccountLock {
    @Override
    public void lockAccount(AccountId accountId) {
        // do nothing
    }

    @Override
    public void releaseAccount(AccountId accountId) {
        // do nothing
    }
}
