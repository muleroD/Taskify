package br.com.mulero.taskify.projection;

import org.springframework.data.web.ProjectedPayload;

@ProjectedPayload
public interface UserFilter {
    String getName();

    String getEmail();
}
