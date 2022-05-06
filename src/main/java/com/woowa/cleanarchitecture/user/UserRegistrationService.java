package com.woowa.cleanarchitecture.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserRegistrationService {
    private final UserRepository userRepository;

    public void registerUser(String name) {
        userRepository.registerUser();
    }
}
