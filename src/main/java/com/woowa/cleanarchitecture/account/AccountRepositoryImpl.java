package com.woowa.cleanarchitecture.account;

public class AccountRepositoryImpl implements AccountRepository {
    @Override
    public void lockAccount(Long accountId) {
        System.out.println("lock account " + accountId);
    }

    @Override
    public void releaseAccount(Long accountId) {
        System.out.println("release account " + accountId);
    }
}
