package com.woowa.cleanarchitecture.common;

import com.woowa.cleanarchitecture.account.domain.AccountId;
import com.woowa.cleanarchitecture.account.domain.Activity;
import com.woowa.cleanarchitecture.account.domain.ActivityId;
import com.woowa.cleanarchitecture.account.domain.Money;

import java.time.LocalDateTime;

public class ActivityTestData {
    public static ActivityBuilder defaultActivity() {
        return new ActivityBuilder()
                .withOwnerAccount(new AccountId(2L))
                .withSourceAccount(new AccountId(2L))
                .withTargetAccount(new AccountId(1L))
                .withMoney(Money.of(999))
                .withTimestamp(LocalDateTime.now());
    }

    public static class ActivityBuilder {
        private ActivityId id;
        private AccountId ownerAccountId;
        private AccountId sourceAccountId;
        private AccountId targetAccountId;
        private Money money;
        private LocalDateTime timestamp;

        public ActivityBuilder withId(ActivityId id) {
            this.id = id;
            return this;
        }

        public ActivityBuilder withOwnerAccount(AccountId ownerAccountId) {
            this.ownerAccountId = ownerAccountId;
            return this;
        }

        public ActivityBuilder withSourceAccount(AccountId sourceAccountId) {
            this.sourceAccountId = sourceAccountId;
            return this;
        }

        public ActivityBuilder withTargetAccount(AccountId targetAccountId) {
            this.targetAccountId = targetAccountId;
            return this;
        }

        public ActivityBuilder withMoney(Money money) {
            this.money = money;
            return this;
        }

        public ActivityBuilder withTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Activity build() {
            return new Activity(id, ownerAccountId, sourceAccountId, targetAccountId, money, timestamp);
        }
    }
}
