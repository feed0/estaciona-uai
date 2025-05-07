package com.chameleon.estaciona_uai.repository;

import com.chameleon.estaciona_uai.domain.users.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ManagerRepository extends JpaRepository<Manager, UUID> {
    Optional<Manager> findByEmail(String email);
}
