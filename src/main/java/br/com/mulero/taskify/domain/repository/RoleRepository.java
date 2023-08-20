package br.com.mulero.taskify.domain.repository;

import br.com.mulero.taskify.domain.model.Role;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends BaseRepository<Role, Long> {

    Optional<Role> findByName(String name);
}
