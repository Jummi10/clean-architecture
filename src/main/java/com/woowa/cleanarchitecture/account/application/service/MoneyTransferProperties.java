package com.woowa.cleanarchitecture.account.application.service;

import com.woowa.cleanarchitecture.account.domain.Money;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

/**
 * Configuration properties for money transfer use cases
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyTransferProperties {
    private Money maximumTransferThreshold = new Money(BigInteger.valueOf(1_000_000L));
}
