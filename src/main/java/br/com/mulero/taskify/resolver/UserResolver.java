package br.com.mulero.taskify.resolver;

import br.com.mulero.taskify.domain.model.User;
import br.com.mulero.taskify.projection.UserFilter;
import br.com.mulero.taskify.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public record UserResolver(UserService userService) {

    @QueryMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @QueryMapping
    public User getUserById(@Argument Long id) {
        return userService.getUserById(id);
    }

    @QueryMapping
    public List<User> filterUsers(@Argument("input") UserFilter filter) {
        return userService.filterUsers(filter);
    }
}
