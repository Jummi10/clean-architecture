package com.woowa.cleanarchitecture.account.domain;

import java.math.BigInteger;

public record Money(BigInteger amount) {
    public static Money add(Money money1, Money money2) {
        return new Money(money1.amount.add(money2.amount));
    }

    public static Money subtract(Money money1, Money money2) {
        return new Money(money1.amount.subtract(money2.amount));
    }

    public static Money of(long amount) {
        return new Money(BigInteger.valueOf(amount));
    }

    public Money negate() {
        return new Money(amount.negate());
    }

    public boolean isPositiveOrZero() {
        return amount.compareTo(BigInteger.ZERO) >= 0;
    }

    public boolean isGreaterThan(Money money) {
        return amount.compareTo(money.amount) >= 1;
    }
}
