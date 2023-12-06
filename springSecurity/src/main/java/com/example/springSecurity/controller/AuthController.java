package com.example.springSecurity.controller;

import com.example.springSecurity.model.AuthenticationRequest;
import com.example.springSecurity.model.AuthenticationResponse;
import com.example.springSecurity.model.UserModel;
import com.example.springSecurity.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    private ResponseEntity<?> subscribeClient(@RequestBody AuthenticationRequest authenticationRequest){
        String username = authenticationRequest.getUsername();
        String password = passwordEncoder.encode(authenticationRequest.getPassword());
        UserModel userModel = new UserModel();
        userModel.setUsername(username);
        userModel.setPassword(password);
        try{
            userRepository.save(userModel);
        }
        catch (Exception e){
            return ResponseEntity.ok(new AuthenticationResponse("Error during client Subscription" +username));
        }
        return ResponseEntity.ok(new AuthenticationResponse("Successful Subscription for client: "+ username));

    }


    @PostMapping("/auth")
    private ResponseEntity<?> authenticateClient(@RequestBody AuthenticationRequest authenticationRequest){

        String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }
        catch (Exception e){
            log.info("Error at auth");
           return ResponseEntity.ok(new AuthenticationResponse("Error during Authentication for client: " +username));
        }
        log.info("Successful auth");
        return ResponseEntity.ok(new AuthenticationResponse("Successful Authentication for client: " +username));
    }

}
