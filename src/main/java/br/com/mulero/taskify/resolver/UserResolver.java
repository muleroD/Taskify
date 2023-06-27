package br.com.mulero.taskify.resolver;

import br.com.mulero.taskify.domain.model.User;
import br.com.mulero.taskify.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class UserResolver {

    private final UserService userService;

    public UserResolver(UserService userService) {
        this.userService = userService;
    }

    @QueryMapping
    public User getUser(@Argument Long id) {
        return userService.getUserById(id);
    }
}
