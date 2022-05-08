package com.woowa.cleanarchitecture.account.application.port.in;

public interface SendMoneyUseCase {
    void sendMoney(Long sourceAccountId, Long targetAccountId, Long amount);
}
