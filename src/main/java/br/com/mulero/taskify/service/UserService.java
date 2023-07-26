package br.com.mulero.taskify.service;

import br.com.mulero.taskify.domain.model.User;
import br.com.mulero.taskify.domain.repository.UserRepository;
import br.com.mulero.taskify.projection.UserFilter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record UserService(UserRepository userRepository) {

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public List<User> filterUsers(UserFilter filter) {
        return userRepository.findAllByFilter(filter);
    }
}
