package ek.osnb.demospringsecurity.app.repository;

import ek.osnb.demospringsecurity.app.model.EntityAuthority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<EntityAuthority,Long> {
    Optional<EntityAuthority> findEntityAuthorityByName(String name);
}
