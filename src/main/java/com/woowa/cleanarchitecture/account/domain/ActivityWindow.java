package com.woowa.cleanarchitecture.account.domain;

import java.math.BigInteger;
import java.util.List;

public record ActivityWindow(List<Activity> activities) {
    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public Money calculateBalance(AccountId id) {
        BigInteger balance = BigInteger.ZERO;
        for (Activity activity : activities) {
            if (activity.targetAccountId().equals(id)) {
                balance = balance.add(activity.money().amount());
            } else if (activity.sourceAccountId().equals(id)) {
                balance = balance.subtract(activity.money().amount());
            }
        }

        return new Money(balance);
    }
}
