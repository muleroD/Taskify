package br.com.mulero.taskify.domain.repository;

import br.com.mulero.taskify.domain.model.User;
import br.com.mulero.taskify.graphql.projection.UserFilter;
import graphql.GraphqlErrorException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {

    default List<User> findAllByFilter(UserFilter filter) {
        User user = new User(filter.getName(), filter.getEmail());
        return findAll(createExample(user));
    }

    default User findAndDeleteById(Long id) {
        User user = findById(id).orElseThrow(() -> new GraphqlErrorException.Builder()
                .message("Usuário não encontrado").build());

        delete(user);
        return user;
    }
}
