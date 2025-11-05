package ek.osnb.demospringsecurity.app.repository;

import ek.osnb.demospringsecurity.app.model.EntityUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<EntityUser,Long> {
    Optional<EntityUser> findUserByUsername(String name);
}
