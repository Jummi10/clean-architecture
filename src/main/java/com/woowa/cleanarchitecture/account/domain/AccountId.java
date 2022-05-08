package com.woowa.cleanarchitecture.account.domain;

import java.util.Objects;

public record AccountId(Long id) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountId accountId = (AccountId) o;
        return Objects.equals(id, accountId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
