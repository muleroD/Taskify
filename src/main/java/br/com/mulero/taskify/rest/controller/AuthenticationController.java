package br.com.mulero.taskify.rest.controller;

import br.com.mulero.taskify.rest.dto.UserDTO;
import br.com.mulero.taskify.rest.request.LoginRequest;
import br.com.mulero.taskify.rest.request.RegisterRequest;
import br.com.mulero.taskify.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static br.com.mulero.taskify.security.jwt.SecurityConstants.LOGIN_URL;
import static br.com.mulero.taskify.security.jwt.SecurityConstants.REGISTER_URL;

@RestController
public record AuthenticationController(UserService userService) {

    @PostMapping(LOGIN_URL)
    public void authenticate(@RequestBody LoginRequest loginRequest) {
        System.out.println(loginRequest);
    }

    @PostMapping(REGISTER_URL)
    public ResponseEntity<UserDTO> register(@RequestBody RegisterRequest registerRequest) {
        return userService.registerUser(registerRequest);
    }
}
