package com.woowa.cleanarchitecture.account.domain;

import java.time.LocalDateTime;

public record Activity(ActivityId activityId, AccountId ownerAccountId, AccountId sourceAccountId,
                       AccountId targetAccountId, Money money, LocalDateTime timestamp) {
}
