package com.woowa.cleanarchitecture.account.domain;

import lombok.NonNull;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ActivityWindow {
    private List<Activity> activities;

    public ActivityWindow(@NonNull List<Activity> activities) {
        this.activities = activities;
    }

    public ActivityWindow(@NonNull Activity... activities) {
        this.activities = new ArrayList<>(Arrays.asList(activities));
    }

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

    public List<Activity> getActivities() {
        return Collections.unmodifiableList(activities);
    }
}
