package com.woowa.cleanarchitecture.account.adapter.out.persistence;

import com.woowa.cleanarchitecture.account.domain.Account;
import com.woowa.cleanarchitecture.account.domain.AccountId;
import com.woowa.cleanarchitecture.account.domain.ActivityWindow;
import com.woowa.cleanarchitecture.account.domain.Money;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;

import static com.woowa.cleanarchitecture.common.AccountTestData.defaultAccount;
import static com.woowa.cleanarchitecture.common.ActivityTestData.defaultActivity;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DataJpaTest
@Import({AccountPersistenceAdapter.class, AccountMapper.class})
class AccountPersistenceAdapterTest {
    @Autowired
    private AccountPersistenceAdapter accountPersistenceAdapter;

    @Autowired
    private ActivityRepository activityRepository;

    @Test
    @Sql("AccountPersistenceAdapterTest.sql")
    void loadAccount() {
        Account account = accountPersistenceAdapter.loadAccount(new AccountId(1L), LocalDateTime.of(2018, 8, 10, 0, 0));

        assertAll(
                () -> assertThat(account.getActivityWindow().getActivities()).hasSize(2),
                () -> assertThat(account.calculateBalance()).isEqualTo(Money.of(500))
        );
    }

    @Test
    void updateActivities() {
        Account account = defaultAccount()
                .withBaselineBalance(Money.of(555L))
                .withActivityWindow(new ActivityWindow(
                        defaultActivity()
                                .withId(null)
                                .withMoney(Money.of(1))
                                .build()
                ))
                .build();

        accountPersistenceAdapter.updateActivities(account);

        assertThat(activityRepository.count()).isEqualTo(1);

        ActivityJpaEntity savedEntity = activityRepository.findAll().get(0);
        assertThat(savedEntity.getAmount()).isEqualTo(1L);
    }
}
