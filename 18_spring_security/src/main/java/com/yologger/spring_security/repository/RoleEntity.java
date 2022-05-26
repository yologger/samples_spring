package com.yologger.spring_security.repository;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
@Getter
@NoArgsConstructor
public class RoleEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    @ManyToMany(mappedBy = "roles")
    private Set<UserEntity> users = new HashSet<UserEntity>();

    @ManyToMany
    @JoinTable(
            name = "role_authority",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id")
    )
    private Set<AuthorityEntity> authorities = new HashSet<AuthorityEntity>();

    @Builder
    public RoleEntity(RoleEnum role, Collection<AuthorityEntity> authorities) {
        this.role = role;
        this.authorities.addAll(authorities);
    }
}
