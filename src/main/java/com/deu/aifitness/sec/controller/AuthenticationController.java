package com.deu.aifitness.sec.controller;

import com.deu.aifitness.model.dto.UserDto;
import com.deu.aifitness.model.request.user.CreateUserRequest;
import com.deu.aifitness.model.request.user.UpdateUserRequest;
import com.deu.aifitness.sec.dto.LoginResponse;
import com.deu.aifitness.sec.dto.RestResponse;
import com.deu.aifitness.sec.dto.SecLoginRequestDto;
import com.deu.aifitness.sec.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody SecLoginRequestDto secLoginRequestDto){

        LoginResponse loginResponse = authenticationService.login(secLoginRequestDto);
        if (loginResponse == null){
            return ResponseEntity.ok(RestResponse.error(loginResponse));
        }
        return ResponseEntity.ok(RestResponse.of(loginResponse));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody CreateUserRequest createUserRequest){

        UserDto cusCustomerDto =authenticationService.register(createUserRequest);

        return ResponseEntity.ok(RestResponse.of(cusCustomerDto));
    }

    @PostMapping("/registerasadmin")
    public ResponseEntity registerAsAdmin(@RequestBody CreateUserRequest createUserRequest){

        UserDto cusCustomerDto =authenticationService.registerAsAdmin(createUserRequest);

        return ResponseEntity.ok(RestResponse.of(cusCustomerDto));
    }


}
