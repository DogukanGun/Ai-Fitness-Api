package com.deu.aifitness.service;


import com.deu.aifitness.configuration.JwtTokenUtil;
import com.deu.aifitness.model.dto.UserDto;
import com.deu.aifitness.model.entity.User;
import com.deu.aifitness.model.request.user.CreateUserRequest;
import com.deu.aifitness.model.request.user.UpdateUserRequest;
import com.deu.aifitness.model.response.user.UpdateUserResponse;
import com.deu.aifitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import static com.deu.aifitness.model.mapper.UserMapper.USER_MAPPER;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final JwtTokenUtil jwtTokenUtil;

    public ResponseEntity<UserDto> createUser(CreateUserRequest createUserRequest){
        User user = USER_MAPPER.createUser(createUserRequest);
        return ResponseEntity.ok(USER_MAPPER.convertToUserDto(userRepository.save(user)));
    }

    private User getUserById(int id){
        return userRepository.findById(id).orElseThrow(()->new NotFoundException("User Not Found"));
    }
    public User getUserByUsername(String username){
        return userRepository.findByUsernameEquals(username).orElseThrow(()->new NotFoundException("User Not Found"));
    }

    public ResponseEntity<UpdateUserResponse> updateUser(UpdateUserRequest updateUserRequest){
        User user = getUserByUsername(updateUserRequest.getUsername());
        if(jwtTokenUtil.validateToken(updateUserRequest.getToken(),user)){
            USER_MAPPER.updateUser(user,updateUserRequest);
            return ResponseEntity.ok(UpdateUserResponse.builder()
                    .message("Updated")
                    .status(HttpStatus.OK)
                    .build());
        }

        return ResponseEntity.ok(UpdateUserResponse.builder()
                .message("Token is expired")
                .status(HttpStatus.OK)
                .build());

    }
}
