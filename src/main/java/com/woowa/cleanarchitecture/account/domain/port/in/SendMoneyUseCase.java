package com.woowa.cleanarchitecture.account.domain.port.in;

public interface SendMoneyUseCase {
    void sendMoney(Long sourceAccountId, Long targetAccountId, Long amount);
}
