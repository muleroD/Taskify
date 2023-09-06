package br.com.mulero.taskify.graphql.projection;

import br.com.mulero.taskify.rest.enumerator.Role;
import br.com.mulero.taskify.rest.enumerator.Status;
import org.springframework.data.web.ProjectedPayload;

@ProjectedPayload
public interface UserFilter {
    String getName();

    String getEmail();

    Role getRole();

    Status getStatus();
}
