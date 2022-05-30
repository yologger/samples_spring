package com.yologger.samples.token.util;

import com.yologger.samples.token.repository.AuthorityType;
import com.yologger.samples.token.repository.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(
        classes = {TokenProvider.class}
)
class TokenProviderTest {

    @Autowired TokenProvider tokenProvider;

    @Test
    public void test() {
        UserEntity user = UserEntity.builder()
                .name("Smith")
                .password("312313")
                .authority(AuthorityType.USER)
                .build();

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                user.getName(),
                user.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(user.getAuthority().getDescription()))
        );

        String token = tokenProvider.createToken(authentication);

        Authentication retrievedAuth = tokenProvider.getAuthentication(token);
        assertThat(retrievedAuth.getName()).isEqualTo(authentication.getName());

        assertThat(tokenProvider.validateToken(token)).isTrue();
    }
}