package com.anurag.springsecurityjwt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by anurag on 4/6/20.
 */
@RestController
public class ResourceController {
    @GetMapping("/hello")
    public String testResource() {
        return "<h1>Hello</h1>";
    }
}

