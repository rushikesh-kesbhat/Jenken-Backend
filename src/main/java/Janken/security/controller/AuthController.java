package Janken.security.controller;

import Janken.security.dto.AuthenticationRequestDto;
import Janken.security.dto.AuthenticationResponseDto;
import Janken.security.dto.RegistrationRequestDto;
import Janken.security.model.User;
import Janken.security.service.AuthenticationService;
import Janken.security.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    @RequestMapping("/auth")
    @RestController
    public class AuthenticationController {


        @Autowired
        JwtService jwtService;

        @Autowired
        AuthenticationService authenticationService;


        @PostMapping("/login")
        public ResponseEntity<AuthenticationResponseDto> authenticate(@RequestBody AuthenticationRequestDto loginUserDto) {
            User authenticatedUser = authenticationService.authenticate(loginUserDto);
            String jwtToken = jwtService.generateToken((UserDetails) authenticatedUser);
            AuthenticationResponseDto loginResponse = new AuthenticationResponseDto();
            loginResponse.setToken(jwtToken);
            loginResponse.setExpiresIn(jwtService.getExpirationTime());

            return ResponseEntity.ok(loginResponse);
        }
    }
}