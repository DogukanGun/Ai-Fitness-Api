package com.deu.aifitness.sec.security;

import com.deu.aifitness.model.entity.User;
import com.deu.aifitness.service.UserEntityService;
import com.deu.aifitness.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final UserEntityService cusCustomerEntityService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User cusCustomer = cusCustomerEntityService.getUserByUsername(username);

        return JwtUserDetails.create(cusCustomer);
    }

    public UserDetails loadUserByUserId(Integer id) {

        User cusCustomer = cusCustomerEntityService.getUserById(id);

        return JwtUserDetails.create(cusCustomer);
    }
}
