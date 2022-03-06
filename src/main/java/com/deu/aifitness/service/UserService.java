package com.deu.aifitness.service;


import com.deu.aifitness.model.dto.UserDto;
import com.deu.aifitness.model.entity.User;
import com.deu.aifitness.model.request.user.CreateUserRequest;
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



}
