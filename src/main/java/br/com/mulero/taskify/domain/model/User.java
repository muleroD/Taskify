package br.com.mulero.taskify.domain.model;

import br.com.mulero.taskify.domain.repository.BaseRepository;
import br.com.mulero.taskify.rest.dto.UserDTO;
import br.com.mulero.taskify.rest.enumerator.Role;
import br.com.mulero.taskify.rest.enumerator.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.domain.Example;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "created_at", insertable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    public User(String email) {
        this.email = email;
    }

    public User(String email, String password) {
        this(email);
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    public Example<User> toExample() {
        return Example.of(this, BaseRepository.getExampleMatcher());
    }

    public UserDTO toDTO() {
        return new UserDTO(id, profile.getName(), email);
    }
}
