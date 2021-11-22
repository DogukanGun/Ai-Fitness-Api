package com.deu.aifitness.controller;


import com.deu.aifitness.model.request.user.LoginRequest;
import com.deu.aifitness.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @SneakyThrows
    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        return authenticationService.login(loginRequest);
    }

    // TODO: 11/22/2021 Password degistirme gelmeli belkide reset etme
}
