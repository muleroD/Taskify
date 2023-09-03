package br.com.mulero.taskify.rest.controller;

import br.com.mulero.taskify.rest.dto.UserDTO;
import br.com.mulero.taskify.rest.request.RegisterRequest;
import br.com.mulero.taskify.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static br.com.mulero.taskify.security.jwt.SecurityConstants.REGISTER_URL;

@RestController
public class AuthenticationController {

    private final UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(REGISTER_URL)
    public ResponseEntity<UserDTO> register(@RequestBody RegisterRequest registerRequest) {
        return userService.registerUser(registerRequest);
    }
}
