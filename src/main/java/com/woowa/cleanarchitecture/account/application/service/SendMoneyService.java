package com.woowa.cleanarchitecture.account.application.service;

import com.woowa.cleanarchitecture.account.application.port.in.SendMoneyCommand;
import com.woowa.cleanarchitecture.account.application.port.in.SendMoneyUseCase;
import com.woowa.cleanarchitecture.account.application.port.out.AccountLock;
import com.woowa.cleanarchitecture.account.application.port.out.LoadAccountPort;
import com.woowa.cleanarchitecture.account.application.port.out.UpdateAccountStatePort;
import com.woowa.cleanarchitecture.account.domain.Account;
import com.woowa.cleanarchitecture.account.domain.AccountId;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Transactional
public class SendMoneyService implements SendMoneyUseCase {
    private final LoadAccountPort loadAccountPort;
    private final UpdateAccountStatePort updateAccountStatePort;
    private final AccountLock accountLock;
    private final MoneyTransferProperties moneyTransferProperties;

    @Override
    public boolean sendMoney(SendMoneyCommand command) {
        checkThreshold(command);

        LocalDateTime baselineDate = LocalDateTime.now().minusDays(10);
        Account sourceAccount = loadAccountPort.loadAccount(command.getSourceAccountId(), baselineDate);
        Account targetAccount = loadAccountPort.loadAccount(command.getTargetAccountId(), baselineDate);

        AccountId sourceAccountId = sourceAccount.getId();
        AccountId targetAccountId = targetAccount.getId();

        accountLock.lockAccount(sourceAccountId);
        if (!sourceAccount.withdraw(command.getMoney(), targetAccountId)) {
            accountLock.releaseAccount(sourceAccountId);
            return false;
        }

        accountLock.lockAccount(targetAccountId);
        if (!sourceAccount.deposit(command.getMoney(), sourceAccountId)) {
            accountLock.releaseAccount(sourceAccountId);
            accountLock.releaseAccount(targetAccountId);
            return false;
        }

        updateAccountStatePort.updateActivities(sourceAccount);
        updateAccountStatePort.updateActivities(targetAccount);

        accountLock.releaseAccount(sourceAccountId);
        accountLock.releaseAccount(targetAccountId);

        return true;
    }

    private void checkThreshold(SendMoneyCommand command) {
        if (command.getMoney().isGreaterThan(moneyTransferProperties.getMaximumTransferThreshold())) {
            throw new ThresholdExceededException(moneyTransferProperties.getMaximumTransferThreshold(), command.getMoney());
        }
    }
}
