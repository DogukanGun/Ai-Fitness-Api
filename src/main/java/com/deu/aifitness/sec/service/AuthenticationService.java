package com.deu.aifitness.sec.service;


import com.deu.aifitness.model.dto.UserDto;
import com.deu.aifitness.model.entity.User;
import com.deu.aifitness.model.request.user.CreateUserRequest;
import com.deu.aifitness.model.request.user.UpdateUserRequest;
import com.deu.aifitness.sec.dto.LoginResponse;
import com.deu.aifitness.sec.dto.SecLoginRequestDto;
import com.deu.aifitness.sec.enums.EnumJwtConstant;
import com.deu.aifitness.sec.security.JwtTokenGenerator;
import com.deu.aifitness.sec.security.JwtUserDetails;
import com.deu.aifitness.service.UserEntityService;
import com.deu.aifitness.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import static com.deu.aifitness.model.mapper.UserMapper.USER_MAPPER;


@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserEntityService cusCustomerEntityService;
    private final UserService cusCustomerService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenGenerator jwtTokenGenerator;

    public UserDto register(CreateUserRequest cusCustomerSaveRequestDto) {

        UserDto cusCustomerDto = cusCustomerService.createUser(cusCustomerSaveRequestDto);
        return cusCustomerDto;
    }

    public UserDto getProfile(UpdateUserRequest updateUserRequest){
        return cusCustomerService.getUserProfile(updateUserRequest);
    }

    public UserDto updateUser(UpdateUserRequest updateUserRequest){
        return cusCustomerService.updateUser(updateUserRequest);
    }
    public LoginResponse login(SecLoginRequestDto secLoginRequestDto) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(secLoginRequestDto.getUsername(), secLoginRequestDto.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenGenerator.generateJwtToken(authentication);

        String bearer = EnumJwtConstant.BEARER.getConstant();

        LoginResponse loginResponse = LoginResponse.builder()
                .username(secLoginRequestDto.getUsername())
                .token(bearer)
                .build();

        return loginResponse;
    }

    public User getCurrentCustomer() {

        JwtUserDetails jwtUserDetails = getCurrentJwtUserDetails();

        User cusCustomer = null;
        if (jwtUserDetails != null){
            cusCustomer = cusCustomerEntityService.getUserById(jwtUserDetails.getId());
        }

        return cusCustomer;
    }

    public Integer getCurrentCustomerId(){

        JwtUserDetails jwtUserDetails = getCurrentJwtUserDetails();

        return jwtUserDetails.getId();
    }

    private JwtUserDetails getCurrentJwtUserDetails() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        JwtUserDetails jwtUserDetails = null;
        if (authentication != null && authentication.getPrincipal() instanceof JwtUserDetails){
            jwtUserDetails = (JwtUserDetails) authentication.getPrincipal();
        }
        return jwtUserDetails;
    }
}
