package com.yologger.samples.token.repository;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    private AuthorityType authority;

    @Builder
    public UserEntity(String name, String password, AuthorityType authority) {
        this.name = name;
        this.password = password;
        this.authority = authority;
    }
}
