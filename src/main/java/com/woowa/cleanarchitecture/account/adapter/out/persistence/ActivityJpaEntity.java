package com.woowa.cleanarchitecture.account.adapter.out.persistence;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "activity")
@Entity
class ActivityJpaEntity {
    @Id
    @GeneratedValue
    private Long id;

    private Long ownerAccountId;
    private Long sourceAccountId;
    private Long targetAccountId;
    private Long amount;
    private LocalDateTime timestamp;
}
