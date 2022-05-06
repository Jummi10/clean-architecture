package com.woowa.cleanarchitecture.account;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Account {
    private final String name;
    private final Long amount;
}
