package br.com.mulero.taskify.domain.repository;

import br.com.mulero.taskify.domain.model.User;
import br.com.mulero.taskify.graphql.projection.UserFilter;
import graphql.GraphqlErrorException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {

    default List<User> findAllByFilter(UserFilter filter) {
        return findAll(new User(filter.getName(), filter.getEmail()).toExample());
    }

    default User findAndDeleteById(Long id) {
        User user = findById(id).orElseThrow(() -> new GraphqlErrorException.Builder()
                .message("Usuário não encontrado").build());

        delete(user);
        return user;
    }

    Optional<User> findByEmail(String email);
}
