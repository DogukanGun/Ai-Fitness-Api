package com.deu.aifitness.controller;

import com.deu.aifitness.model.dto.UserDto;
import com.deu.aifitness.model.request.user.SaveUserPhotoRequest;
import com.deu.aifitness.model.request.user.UpdateUserRequest;
import com.deu.aifitness.sec.dto.RestResponse;
import com.deu.aifitness.sec.service.AuthenticationService;
import com.deu.aifitness.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationService authenticationService;
    private final UserService userService;

    @PostMapping("/updatephoto")
    public UserDto saveUserPhoto(SaveUserPhotoRequest saveUserPhotoRequest){
        return userService.saveUserPhoto(saveUserPhotoRequest);
    }

    @PostMapping("/getProfile")
    public ResponseEntity getProfile(@RequestBody UpdateUserRequest updateUserRequest){
        return ResponseEntity.ok(RestResponse.of(authenticationService.getProfile(updateUserRequest)));
    }

    @PostMapping("/updateUser")
    public ResponseEntity updateUser(@RequestBody UpdateUserRequest updateUserRequest){
        return ResponseEntity.ok(RestResponse.of(authenticationService.updateUser(updateUserRequest)));
    }
}
