package br.com.mulero.taskify.service;

import br.com.mulero.taskify.domain.model.User;
import br.com.mulero.taskify.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public record UserService(UserRepository userRepository) {

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
}
