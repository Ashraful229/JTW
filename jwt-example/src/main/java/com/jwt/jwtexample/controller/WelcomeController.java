package com.jwt.jwtexample.controller;

import com.jwt.jwtexample.entity.AuthReq;
import com.jwt.jwtexample.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;
    @GetMapping("/")
    public String welcome()
    {
        return "okokok";
    }
    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthReq authReq) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authReq.getUserName(),authReq.getPassword())
            );
        }catch (Exception ex)
        {
            throw new Exception("invalid username or password");
        }
        return jwtUtil.generateToken(authReq.getUserName());
    }

}
