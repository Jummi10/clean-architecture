package com.woowa.cleanarchitecture;

import com.woowa.cleanarchitecture.account.adapter.in.web.SendMoneyController;
import com.woowa.cleanarchitecture.account.adapter.out.persistence.*;
import com.woowa.cleanarchitecture.account.application.port.in.SendMoneyUseCase;
import com.woowa.cleanarchitecture.account.application.service.MoneyTransferProperties;
import com.woowa.cleanarchitecture.account.application.service.SendMoneyService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class CleanArchitectureApplication {

    public static void main(String[] args) {
        AccountRepository accountRepository = new AccountRepository() {
            @Override
            public List<AccountJpaEntity> findAll() {
                return null;
            }

            @Override
            public List<AccountJpaEntity> findAll(Sort sort) {
                return null;
            }

            @Override
            public List<AccountJpaEntity> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public <S extends AccountJpaEntity> List<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends AccountJpaEntity> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public <S extends AccountJpaEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
                return null;
            }

            @Override
            public void deleteAllInBatch(Iterable<AccountJpaEntity> entities) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<Long> longs) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public AccountJpaEntity getOne(Long aLong) {
                return null;
            }

            @Override
            public AccountJpaEntity getById(Long aLong) {
                return null;
            }

            @Override
            public <S extends AccountJpaEntity> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends AccountJpaEntity> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public Page<AccountJpaEntity> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends AccountJpaEntity> S save(S entity) {
                return null;
            }

            @Override
            public Optional<AccountJpaEntity> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(AccountJpaEntity entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> longs) {

            }

            @Override
            public void deleteAll(Iterable<? extends AccountJpaEntity> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends AccountJpaEntity> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends AccountJpaEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends AccountJpaEntity> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends AccountJpaEntity> boolean exists(Example<S> example) {
                return false;
            }

            @Override
            public <S extends AccountJpaEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                return null;
            }
        };
        ActivityRepository activityRepository = new ActivityRepository() {
            @Override
            public List<ActivityJpaEntity> findByOwnerAccountIdAndSince(Long ownerAccountId, LocalDateTime since) {
                return null;
            }

            @Override
            public Long getDepositBalanceUntil(Long accountId, LocalDateTime until) {
                return null;
            }

            @Override
            public Long getWithdrawalBalanceUntil(Long accountId, LocalDateTime until) {
                return null;
            }

            @Override
            public List<ActivityJpaEntity> findAll() {
                return null;
            }

            @Override
            public List<ActivityJpaEntity> findAll(Sort sort) {
                return null;
            }

            @Override
            public List<ActivityJpaEntity> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public <S extends ActivityJpaEntity> List<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends ActivityJpaEntity> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public <S extends ActivityJpaEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
                return null;
            }

            @Override
            public void deleteAllInBatch(Iterable<ActivityJpaEntity> entities) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<Long> longs) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public ActivityJpaEntity getOne(Long aLong) {
                return null;
            }

            @Override
            public ActivityJpaEntity getById(Long aLong) {
                return null;
            }

            @Override
            public <S extends ActivityJpaEntity> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends ActivityJpaEntity> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public Page<ActivityJpaEntity> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends ActivityJpaEntity> S save(S entity) {
                return null;
            }

            @Override
            public Optional<ActivityJpaEntity> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(ActivityJpaEntity entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> longs) {

            }

            @Override
            public void deleteAll(Iterable<? extends ActivityJpaEntity> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends ActivityJpaEntity> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends ActivityJpaEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends ActivityJpaEntity> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends ActivityJpaEntity> boolean exists(Example<S> example) {
                return false;
            }

            @Override
            public <S extends ActivityJpaEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                return null;
            }
        };

        AccountPersistenceAdapter accountPersistenceAdapter = new AccountPersistenceAdapter(accountRepository,
                activityRepository, new AccountMapper());

        SendMoneyUseCase sendMoneyUseCase = new SendMoneyService(
                accountPersistenceAdapter, accountPersistenceAdapter, new NoOpAccountLock(), new MoneyTransferProperties());

        SendMoneyController sendMoneyController = new SendMoneyController(sendMoneyUseCase);

        startProcessingWebRequests(sendMoneyController);
    }

    private static void startProcessingWebRequests(SendMoneyController sendMoneyController) {
        // 웹 컨트롤러를 HTTP로 노출
    }

}
