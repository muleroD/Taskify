package br.com.mulero.taskify.domain.model;

import br.com.mulero.taskify.domain.repository.BaseRepository;
import br.com.mulero.taskify.rest.dto.UserDTO;
import br.com.mulero.taskify.rest.enumerator.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.springframework.data.domain.Example;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @Column(name = "created_at", insertable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User(String name, String email, String password) {
        this(name, email);
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    public Example<User> toExample() {
        return Example.of(this, BaseRepository.getExampleMatcher());
    }

    public UserDTO toDTO() {
        return new UserDTO(id, name, email);
    }
}
