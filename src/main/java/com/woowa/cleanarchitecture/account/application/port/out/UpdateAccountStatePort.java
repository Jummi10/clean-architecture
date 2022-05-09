package com.woowa.cleanarchitecture.account.application.port.out;

import com.woowa.cleanarchitecture.account.domain.Account;

public interface UpdateAccountStatePort {
    void updateActivities(Account account);
}
