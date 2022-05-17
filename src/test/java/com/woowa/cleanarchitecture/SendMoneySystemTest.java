package com.woowa.cleanarchitecture;

import com.woowa.cleanarchitecture.account.application.port.out.LoadAccountPort;
import com.woowa.cleanarchitecture.account.domain.Account;
import com.woowa.cleanarchitecture.account.domain.AccountId;
import com.woowa.cleanarchitecture.account.domain.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class SendMoneySystemTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private LoadAccountPort loadAccountPort;

    private String url;

    @BeforeEach
    void setUp() {
        url = "/accounts/send/{sourceAccountId}/{targetAccountId}/{amount}";
    }

    @Test
    @Sql("SendMoneySystemTest.sql")
    void sendMoney() {
        Money initialSourceBalance = sourceAccount().calculateBalance();
        Money initialTargetBalance = targetAccount().calculateBalance();

        ResponseEntity response = whenSendMoney(sourceAccountId(), targetAccountId(), transferredAmount());

        then(response.getStatusCode())
                .isEqualTo(HttpStatus.OK);
        then(sourceAccount().calculateBalance())
                .isEqualTo(initialSourceBalance.minus(transferredAmount()));
        then(targetAccount().calculateBalance())
                .isEqualTo(initialTargetBalance.plus(transferredAmount()));

    }

    private Account sourceAccount() {
        return loadAccount(sourceAccountId());
    }

    private Account targetAccount() {
        return loadAccount(targetAccountId());
    }

    private Account loadAccount(AccountId accountId) {
        return loadAccountPort.loadAccount(accountId, LocalDateTime.now());
    }

    private AccountId sourceAccountId() {
        return new AccountId(1L);
    }

    private AccountId targetAccountId() {
        return new AccountId(2L);
    }

    private ResponseEntity whenSendMoney(AccountId sourceAccountId, AccountId targetAccountId, Money money) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Void> requestEntity = new HttpEntity<>(null, headers);

        return restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                Object.class,
                sourceAccountId.id(),
                targetAccountId.id(),
                money.amount());
    }

    private Money transferredAmount() {
        return Money.of(500L);
    }
}
