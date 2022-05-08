package com.woowa.cleanarchitecture.account.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static java.time.LocalDateTime.now;

@Getter
@AllArgsConstructor
public class Account {

    private AccountId id;

    /**
     * activityWindow의 첫번째 활동 바로 전의 계좌 잔고
     */
    private Money baselineBalance;

    /**
     * 이 계좌의 최근 모든 입출금 활동
     */
    private ActivityWindow activityWindow;

    public boolean withdraw(Money money, AccountId targetAccountId) {
        if (!mayWithdraw(money)) {
            return false;
        }

        Activity withdrawal = new Activity(
                null,
                id,
                id,
                targetAccountId,
                now(),
                money
        );

        activityWindow.addActivity(withdrawal);
        return true;
    }

    public boolean deposit(Money money, AccountId sourceAccountId) {
        Activity deposit = new Activity(
                null,
                id,
                sourceAccountId,
                id,
                now(),
                money
        );

        activityWindow.addActivity(deposit);
        return true;
    }

    /**
     * 현재 잔고 = 기준 잔고 + 최근 활동의 입출금 내역
     *
     * @return 현재 잔고
     */
    public Money calculateBalance() {
        return Money.add(
                baselineBalance,
                activityWindow.calculateBalance(id)
        );
    }

    private boolean mayWithdraw(Money money) {
        return Money.add(
                        calculateBalance(),
                        money.negate()) // subtract
                .isPositiveOrZero();
    }
}
