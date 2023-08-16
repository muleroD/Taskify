package br.com.mulero.taskify.domain.repository;

import br.com.mulero.taskify.domain.model.User;
import br.com.mulero.taskify.graphql.projection.UserFilter;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {

    default List<User> findAllByFilter(UserFilter filter) {
        User user = new User(filter.getName(), filter.getEmail());
        return findAll(createExample(user));
    }

    default User findAndDeleteById(Long id) {
        User user = findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        delete(user);
        return user;
    }
}
