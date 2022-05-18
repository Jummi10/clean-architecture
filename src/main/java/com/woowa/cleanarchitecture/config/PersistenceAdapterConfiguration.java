package com.woowa.cleanarchitecture.config;

import com.woowa.cleanarchitecture.account.adapter.out.persistence.AccountMapper;
import com.woowa.cleanarchitecture.account.adapter.out.persistence.AccountPersistenceAdapter;
import com.woowa.cleanarchitecture.account.adapter.out.persistence.AccountRepository;
import com.woowa.cleanarchitecture.account.adapter.out.persistence.ActivityRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.woowa.cleanarchitecture.account")
public class PersistenceAdapterConfiguration {
    @Bean
    AccountPersistenceAdapter accountPersistenceAdapter(
            AccountRepository accountRepository,
            ActivityRepository activityRepository,
            AccountMapper accountMapper) {
        return new AccountPersistenceAdapter(accountRepository, activityRepository, accountMapper);
    }

    @Bean
    AccountMapper accountMapper() {
        return new AccountMapper();
    }
}
