package com.yologger.spring_security.repository;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authority")
@Getter
@NoArgsConstructor
public class AuthorityEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private AuthorityEnum authority;

    @ManyToMany(mappedBy = "authorities")
    private Set<RoleEntity> roles = new HashSet<RoleEntity>();

    @Builder
    public AuthorityEntity(AuthorityEnum authority) {
        this.authority = authority;
    }
}
