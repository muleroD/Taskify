package br.com.mulero.taskify.domain.repository;

import br.com.mulero.taskify.domain.model.User;
import br.com.mulero.taskify.projection.UserFilter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {

    default List<User> findAllByFilter(UserFilter filter) {
        User user = new User(filter.getName(), filter.getEmail());
        return findAll(createExample(user));
    }
}
