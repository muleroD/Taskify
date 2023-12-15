package br.com.mulero.taskify.service;

import br.com.mulero.taskify.domain.model.Profile;
import br.com.mulero.taskify.domain.model.User;
import br.com.mulero.taskify.domain.repository.ProfileRepository;
import br.com.mulero.taskify.domain.repository.UserRepository;
import br.com.mulero.taskify.graphql.projection.UserFilter;
import br.com.mulero.taskify.graphql.types.UserInput;
import br.com.mulero.taskify.infrastructure.exception.UserAlreadyExistException;
import br.com.mulero.taskify.rest.enumerator.Role;
import br.com.mulero.taskify.rest.enumerator.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class UserService {

    public final UserRepository userRepository;
    public final ProfileRepository profileRepository;

    public static final String USER_NOT_FOUND = "Usuário não encontrado com o id: {}";
    public static final String USER_ALREADY_EXISTS = "Usuário já cadastrado";

    public UserService(UserRepository userRepository, ProfileRepository profileRepository) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
    }

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

    @Transactional(rollbackFor = Exception.class)
    public User registerUser(UserInput userInput) {
        User user = new User();
        user.setEmail(userInput.email());

        if (userRepository.exists(user.toExample()))
            throw new UserAlreadyExistException(USER_ALREADY_EXISTS);

        Profile profile = Profile.builder()
                .name(userInput.profile().name())
                .birthDate(userInput.profile().birthDate())
                .build();
        profileRepository.save(profile);

        user.setPassword(userInput.password());
        user.setProfile(profile);

        userInput.role().ifPresentOrElse(user::setRole, () -> user.setRole(Role.USER));
        user.setStatus(Status.PENDING);

        return userRepository.save(user);
    }

    public User deleteUser(Long id) {
        return userRepository.findAndDeleteById(id);
    }
}
