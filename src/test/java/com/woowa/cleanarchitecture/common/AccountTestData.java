package com.woowa.cleanarchitecture.common;

import com.woowa.cleanarchitecture.account.domain.Account;
import com.woowa.cleanarchitecture.account.domain.AccountId;
import com.woowa.cleanarchitecture.account.domain.ActivityWindow;
import com.woowa.cleanarchitecture.account.domain.Money;

public class AccountTestData {
    public static AccountBuilder defaultAccount() {
        return new AccountBuilder()
                .withAccountId(new AccountId(2L))
                .withBaselineBalance(Money.of(999))
                .withActivityWindow(new ActivityWindow(
                        ActivityTestData.defaultActivity().build(),
                        ActivityTestData.defaultActivity().build()
                ));
    }

    public static class AccountBuilder {
        private AccountId accountId;
        private Money baselineBalance;
        private ActivityWindow activityWindow;

        public AccountBuilder withAccountId(AccountId accountId) {
            this.accountId = accountId;
            return this;
        }

        public AccountBuilder withBaselineBalance(Money baselineBalance) {
            this.baselineBalance = baselineBalance;
            return this;
        }

        public AccountBuilder withActivityWindow(ActivityWindow activityWindow) {
            this.activityWindow = activityWindow;
            return this;
        }

        public Account build() {
            return Account.withId(accountId, baselineBalance, activityWindow);
        }
    }
}
