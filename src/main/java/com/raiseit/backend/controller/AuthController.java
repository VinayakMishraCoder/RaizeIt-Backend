package com.raiseit.backend.controller;

import com.raiseit.backend.dto.auth.AuthRequest;
import com.raiseit.backend.dto.auth.SuperUserRegisterRequest;
import com.raiseit.backend.service.AuthService;
import com.raiseit.backend.utils.ResultWrapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
@Validated
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ResultWrapper<?>> register(@Valid @RequestBody SuperUserRegisterRequest request) {
        authService.register(request);
        return ResponseEntity.ok(ResultWrapper.success("User registered successfully",request));
    }

    @PostMapping("/login")
    public ResponseEntity<ResultWrapper<?>> login(@Valid @RequestBody AuthRequest request) {
        String token = authService.login(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(ResultWrapper.success("Login success",token));
    }
}
