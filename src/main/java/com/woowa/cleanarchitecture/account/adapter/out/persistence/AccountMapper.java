package com.woowa.cleanarchitecture.account.adapter.out.persistence;

import com.woowa.cleanarchitecture.account.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class AccountMapper {
    Account mapJpaEntityToDomainEntity(AccountJpaEntity account,
                                       List<ActivityJpaEntity> activities,
                                       Long withdrawalBalance,
                                       Long depositBalance) {
        Money baselineBalance = Money.subtract(
                Money.of(depositBalance),
                Money.of(withdrawalBalance)
        );

        return Account.withId(
                new AccountId(account.getId()),
                baselineBalance,
                new ActivityWindow(activities.stream()
                        .map(this::mapJpaEntityToDomainEntity)
                        .collect(Collectors.toList())
                )
        );
    }

    Activity mapJpaEntityToDomainEntity(ActivityJpaEntity activity) {
        return new Activity(
                new ActivityId(activity.getId()),
                new AccountId(activity.getOwnerAccountId()),
                new AccountId(activity.getSourceAccountId()),
                new AccountId(activity.getTargetAccountId()),
                Money.of(activity.getAmount()),
                activity.getTimestamp()
        );
    }

    ActivityJpaEntity mapDomainEntityToJpaEntity(Activity activity) {
        return new ActivityJpaEntity(
                activity.activityId() == null ? null : activity.activityId().id(),
                activity.ownerAccountId().id(),
                activity.sourceAccountId().id(),
                activity.targetAccountId().id(),
                activity.money().amount().longValue(),
                activity.timestamp()
        );
    }
}
