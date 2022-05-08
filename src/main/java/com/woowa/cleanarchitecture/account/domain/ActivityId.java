package com.woowa.cleanarchitecture.account.domain;

import java.util.Objects;

public record ActivityId(Long id) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityId that = (ActivityId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
