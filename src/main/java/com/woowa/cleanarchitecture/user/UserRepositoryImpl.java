package com.woowa.cleanarchitecture.user;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public User registerUser() {
        System.out.println("register user");
        return new User("clean");
    }
}
