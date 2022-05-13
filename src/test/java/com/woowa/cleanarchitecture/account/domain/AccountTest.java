package com.woowa.cleanarchitecture.account.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class AccountTest {
    @Test
    void succeedWithdrawal() {
        AccountId accountId = new AccountId(1L);
        AccountId sourceAccountId = new AccountId(2L);
        List<Activity> activities = new ArrayList<>() {{
            add(new Activity(new ActivityId(1L), accountId, sourceAccountId, accountId, Money.of(999L),
                    LocalDateTime.now()));
            add(new Activity(new ActivityId(2L), accountId, sourceAccountId, accountId, Money.of(1L),
                    LocalDateTime.now()));
        }};
        Account account = Account.withId(
                accountId,
                Money.of(555L),
                new ActivityWindow(activities)
        );

        boolean success = account.withdraw(Money.of(555L), new AccountId(99L));

        assertAll(
                () -> assertThat(success).isTrue(),
                () -> assertThat(account.getActivityWindow().activities()).hasSize(3),
                () -> assertThat(account.calculateBalance()).isEqualTo(Money.of(1000L))
        );
    }
}
