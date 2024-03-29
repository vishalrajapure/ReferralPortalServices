package com.vaibhav.minion.referralportal.controller;

import com.vaibhav.minion.referralportal.service.IAuthService;
import com.vaibhav.minion.referralportal.utility.LoginRequest;
import com.vaibhav.minion.referralportal.utility.LoginResponse;
import com.vaibhav.minion.referralportal.utility.RegisterReposne;
import com.vaibhav.minion.referralportal.utility.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/rp/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private IAuthService authService;

    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public LoginResponse loginUser(@RequestBody LoginRequest loginRequest) {
        return authService.loginUser(loginRequest);
    }

    @PostMapping(value = "/register", consumes = "application/json", produces = "application/json")
    public RegisterReposne RegisterUser(@RequestBody RegisterRequest registerRequest) {
        return authService.registerUser(registerRequest);
    }

}
