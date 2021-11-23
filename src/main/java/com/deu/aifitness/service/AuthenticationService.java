package com.deu.aifitness.service;

import com.deu.aifitness.configuration.JwtTokenUtil;
import com.deu.aifitness.model.entity.User;
import com.deu.aifitness.model.request.user.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@Service
@CrossOrigin
@RequiredArgsConstructor
public class AuthenticationService {
//    private final AuthenticationManager authenticationManager;

    private final JwtTokenUtil jwtTokenUtil;

    private final UserService userService;

    public ResponseEntity<?> login(LoginRequest loginRequest) throws Exception {

//        authenticate(loginRequest.getUsername(), loginRequest.getPassword());

        final User userDetails = userService.getUserByUsername(loginRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(token);
    }
//    private void authenticate(String username, String password) throws Exception {
//        try {
////            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//        } catch (DisabledException e) {
//            throw new Exception("USER_DISABLED", e);
//        } catch (BadCredentialsException e) {
//            throw new Exception("INVALID_CREDENTIALS", e);
//        }
//    }

}
