package br.com.mulero.taskify.domain.specification;

import br.com.mulero.taskify.domain.model.User;
import br.com.mulero.taskify.domain.model.User_;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {

    public static Specification<User> withName(String name) {
        return (root, query, builder) -> builder.equal(root.get(User_.NAME), name);
    }

    public static Specification<User> withEmail(String email) {
        return (root, query, builder) -> builder.equal(root.get(User_.EMAIL), email);
    }
}
