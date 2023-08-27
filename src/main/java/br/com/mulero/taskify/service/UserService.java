package br.com.mulero.taskify.service;

import br.com.mulero.taskify.domain.model.User;
import br.com.mulero.taskify.domain.repository.UserRepository;
import br.com.mulero.taskify.graphql.projection.UserFilter;
import br.com.mulero.taskify.infrastructure.exception.UserAlreadyExistException;
import br.com.mulero.taskify.rest.dto.UserDTO;
import br.com.mulero.taskify.rest.request.RegisterRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public record UserService(UserRepository userRepository) {

    public static final String USER_NOT_FOUND = "Usuário não encontrado com o id: {}";
    public static final String USER_ALREADY_EXISTS = "Usuário já cadastrado";

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseGet(() -> {
            log.info(USER_NOT_FOUND, id);
            return null;
        });
    }

    public List<User> getUsersByFilter(UserFilter filter) {
        return userRepository.findAllByFilter(filter);
    }

    public ResponseEntity<UserDTO> registerUser(RegisterRequest newUser) {
        User user = new User();
        user.setEmail(newUser.email());

        if (userRepository.exists(user.toExample()))
            throw new UserAlreadyExistException(USER_ALREADY_EXISTS);

        user.setName(newUser.name());
        user.setPassword(newUser.password());
        user.setRole(newUser.role());

        UserDTO dto = userRepository.save(user).toDTO();

        return ResponseEntity.ok(dto);
    }

    public User deleteUser(Long id) {
        return userRepository.findAndDeleteById(id);
    }
}
