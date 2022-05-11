package com.woowa.cleanarchitecture.account.application.service;

import com.woowa.cleanarchitecture.account.domain.Money;

public class ThresholdExceededException extends RuntimeException {
    public ThresholdExceededException(Money threshold, Money money) {
        super(String.format("Maximum threshold for transferring money exceeded: tried to transfer %s but threshold " +
                "is %s!", money, threshold));
    }
}
