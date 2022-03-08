package com.deu.aifitness.service;


import com.deu.aifitness.model.dto.UserDto;
import com.deu.aifitness.model.entity.User;
import com.deu.aifitness.model.request.user.CreateUserRequest;
import com.deu.aifitness.model.request.user.UpdateUserRequest;
import com.deu.aifitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import static com.deu.aifitness.model.mapper.UserMapper.USER_MAPPER;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserDto createUser(CreateUserRequest createUserRequest){
        User user = USER_MAPPER.createUser(createUserRequest);
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        return USER_MAPPER.convertToUserDto(userRepository.save(user));
    }

    public UserDto getUserProfile(UpdateUserRequest updateUserRequest){
        return USER_MAPPER.convertToUserDto(userRepository.findByUsernameEquals(updateUserRequest.getUsername())
                .orElseThrow(()->new NotFoundException("User Not Found")));
    }

    public UserDto updateUser(UpdateUserRequest updateUserRequest){
        if (!updateUserRequest.getUsername().equals("")){
            User user = userRepository.findByUsernameEquals(updateUserRequest.getUsername())
                    .orElseThrow(()->new NotFoundException("User Not Found"));
            if (!updateUserRequest.getPhoneNumber().equals("")){
                user.setPhoneNumber(updateUserRequest.getPhoneNumber());
            }
            if (!updateUserRequest.getEmail().equals("")){
                user.setEmail(updateUserRequest.getEmail());
            }
            return USER_MAPPER.convertToUserDto(userRepository.save(user));
        }
        throw new NotFoundException("User not found");
    }



}
