package com.woowa.cleanarchitecture.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRegistrationService userRegistrationService;

    @PostMapping("/register/{userName}")
    public void registerUser(@PathVariable String userName) {
        userRegistrationService.registerUser(userName);
    }
}
