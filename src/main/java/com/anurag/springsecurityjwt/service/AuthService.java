package com.anurag.springsecurityjwt.service;

import com.anurag.springsecurityjwt.dto.AuthenticationRequestDto;
import com.anurag.springsecurityjwt.dto.AuthenticationResponseDto;
import com.anurag.springsecurityjwt.util.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by anurag on 6/6/20.
 */
@Service
@AllArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;


    public AuthenticationResponseDto login(AuthenticationRequestDto authenticationRequestDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequestDto.getUserName(), authenticationRequestDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtils.generateToken(new User(authenticationRequestDto.getUserName(), authenticationRequestDto.getPassword(), new ArrayList<>()));
        return new AuthenticationResponseDto(authenticationRequestDto.getUserName(), token);
    }
}
