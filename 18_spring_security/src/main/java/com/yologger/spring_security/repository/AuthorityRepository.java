package com.yologger.spring_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<AuthorityEntity, Long> {
    public AuthorityEntity findByAuthority(AuthorityEnum authority);
}
