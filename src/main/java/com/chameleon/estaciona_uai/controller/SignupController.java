package com.chameleon.estaciona_uai.controller;

import com.chameleon.estaciona_uai.dto.request.ManagerSignupRequestDto;
import com.chameleon.estaciona_uai.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/signup")
public class SignupController {

    @Autowired
    private SignupService signupService;

    @PostMapping("/manager")
    public ResponseEntity<?> signupManager(@Valid @RequestBody ManagerSignupRequestDto signupRequest) {
        try {
            signupService.signupManager(signupRequest);
            return ResponseEntity.ok("Manager registered successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
