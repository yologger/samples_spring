package com.yologger.spring_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    public RoleEntity findByRole(RoleEnum role);
}
