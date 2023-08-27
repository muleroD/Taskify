package br.com.mulero.taskify.security;

import br.com.mulero.taskify.domain.model.User;
import br.com.mulero.taskify.domain.repository.UserRepository;
import org.hibernate.Hibernate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static org.springframework.security.core.userdetails.User.builder;

@Service
public record UserDetailsServiceImpl(UserRepository userRepository) implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        return builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole().name())
                .build();
    }
}
