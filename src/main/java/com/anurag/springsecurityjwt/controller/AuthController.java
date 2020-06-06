package com.anurag.springsecurityjwt.controller;

import com.anurag.springsecurityjwt.dto.AuthenticationRequestDto;
import com.anurag.springsecurityjwt.dto.AuthenticationResponseDto;
import com.anurag.springsecurityjwt.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by anurag on 6/6/20.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public AuthenticationResponseDto login(@RequestBody AuthenticationRequestDto authenticationRequestDto) {
        return authService.login(authenticationRequestDto);
    }
}
