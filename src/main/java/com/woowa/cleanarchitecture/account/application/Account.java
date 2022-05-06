package com.woowa.cleanarchitecture.account.application;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Account {
    private final Long id;
    private final Long amount;
}
