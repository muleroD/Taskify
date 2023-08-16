package br.com.mulero.taskify.service;

import br.com.mulero.taskify.domain.model.User;
import br.com.mulero.taskify.domain.repository.UserRepository;
import br.com.mulero.taskify.graphql.projection.UserFilter;
import br.com.mulero.taskify.graphql.types.UserInput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public record UserService(UserRepository userRepository) {

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseGet(() -> {
            log.info("Usuário não encontrado com o id: {}", id);
            return null;
        });
    }

    public List<User> getUsersByFilter(UserFilter filter) {
        return userRepository.findAllByFilter(filter);
    }

    public User addUser(UserInput userInput) {
        User user = new User();
        user.setEmail(userInput.email());

        if (userRepository.exists(user))
            throw new RuntimeException("Usuário já cadastrado");

        user.setName(userInput.name());
        user.setPassword(userInput.password());

        return userRepository.save(user);
    }

    public User deleteUser(Long id) {
        return userRepository.findAndDeleteById(id);
    }
}
