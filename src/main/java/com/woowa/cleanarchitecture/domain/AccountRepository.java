package com.woowa.cleanarchitecture.domain;

public interface AccountRepository {
    void lockAccount(Long sourceAccountId);

    void releaseAccount(Long sourceAccountId);
}
