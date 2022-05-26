package com.yologger.spring_security.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static com.google.common.truth.Truth.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Commit
class UserRepositoryTest {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private RoleRepository roleRepository;

    @BeforeEach
    public void setUp() {
        AuthorityEntity authority = AuthorityEntity.builder()
                .authority(AuthorityEnum.CREATE_USER)
                .build();
        authorityRepository.save(authority);

        RoleEntity role = RoleEntity.builder()
                .role(RoleEnum.ROLE_USER)
                .authorities(Arrays.asList(authority))
                .build();
        roleRepository.save(role);
    }

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() {

        RoleEntity role = roleRepository.findByRole(RoleEnum.ROLE_USER);

        UserEntity user = UserEntity.builder()
                .email("paul@gmail.com")
                .password("1234")
                .roles(Arrays.asList(role))
                .build();

        userRepository.save(user);

        List<UserEntity> users = userRepository.findAll();
        assertThat(users.size()).isEqualTo(1);

        Set<RoleEntity> roles = users.get(0).getRoles();
    }
}