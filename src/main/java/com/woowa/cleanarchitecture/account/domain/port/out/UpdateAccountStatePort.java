package com.woowa.cleanarchitecture.account.domain.port.out;

import com.woowa.cleanarchitecture.account.application.Account;

public interface UpdateAccountStatePort {
    void updateActivities(Account account);
}
