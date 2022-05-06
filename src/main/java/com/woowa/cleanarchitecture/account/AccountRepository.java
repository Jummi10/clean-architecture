package com.woowa.cleanarchitecture.account;

public interface AccountRepository {
    void lockAccount(Long sourceAccountId);

    void releaseAccount(Long sourceAccountId);
}
