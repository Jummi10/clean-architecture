package com.woowa.cleanarchitecture.account.application.service;

import com.woowa.cleanarchitecture.account.application.port.in.SendMoneyCommand;
import com.woowa.cleanarchitecture.account.application.port.in.SendMoneyUseCase;
import com.woowa.cleanarchitecture.account.application.port.out.AccountLock;
import com.woowa.cleanarchitecture.account.application.port.out.LoadAccountPort;
import com.woowa.cleanarchitecture.account.application.port.out.UpdateAccountStatePort;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
public class SendMoneyService implements SendMoneyUseCase {
    private final LoadAccountPort loadAccountPort;
    private final UpdateAccountStatePort updateAccountStatePort;
    private final AccountLock accountLock;

    @Override
    public boolean sendMoney(SendMoneyCommand command) {
        // TODO: 비즈니스 규칙 검증
        // TODO: 모델 상태 조작
        // TODO: 출력 값 반환
        return false;
    }
}
