package com.deu.aifitness.controller;


import com.deu.aifitness.model.dto.UserDto;
import com.deu.aifitness.model.request.user.CreateUserRequest;
import com.deu.aifitness.model.request.user.UpdateUserRequest;
import com.deu.aifitness.model.response.user.UpdateUserResponse;
import com.deu.aifitness.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("register")
    public ResponseEntity<UserDto> registerUser(@RequestBody CreateUserRequest createUserRequest){
        return userService.createUser(createUserRequest);
    }

    @PutMapping("update")
    public ResponseEntity<UpdateUserResponse> updateUser(@RequestBody UpdateUserRequest updateUserRequest){
        return userService.updateUser(updateUserRequest);
    }


}
