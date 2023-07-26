package br.com.mulero.taskify.graphql.resolver;

import br.com.mulero.taskify.domain.model.User;
import br.com.mulero.taskify.graphql.projection.UserFilter;
import br.com.mulero.taskify.service.UserService;
import br.com.mulero.taskify.graphql.types.UserInput;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
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
    public List<User> getUsersByFilter(@Argument("input") UserFilter filter) {
        return userService.getUsersByFilter(filter);
    }

    @MutationMapping
    public User addUser(@Argument("input") UserInput userInput) {
        System.out.println(userInput);
        return null;
//        return userService.createUser(userInput);
    }
}
