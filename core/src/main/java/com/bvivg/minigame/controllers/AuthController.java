package com.bvivg.minigame.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthController {

  @PostMapping("/login")
  public ResponseEntity<String> login() {
    return ResponseEntity.ok("Login successful");
  }

  @PostMapping("/register")
  public ResponseEntity<String> register() {
    return ResponseEntity.ok("Registration successful");
  }
}
