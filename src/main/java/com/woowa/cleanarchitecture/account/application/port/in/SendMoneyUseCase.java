package com.woowa.cleanarchitecture.account.application.port.in;

import javax.validation.Valid;

public interface SendMoneyUseCase {
    boolean sendMoney(@Valid SendMoneyCommand command);
}
