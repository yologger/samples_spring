package com.yologger.spring_redis.repository;

import com.yologger.spring_redis.config.TestRedisConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.context.annotation.Import;

import static com.google.common.truth.Truth.assertThat;

@DataRedisTest
@Import({TestRedisConfig.class})
@DisplayName("PersonRepository 테스트")
public class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @AfterEach
    public void tearDown() {
        personRepository.deleteAll();
    }

    @Test
    @DisplayName("save() 테스트")
    public void save() {
        Person p1 = Person.builder()
                .email("Paul@gmail.com")
                .name("Paul")
                .password("1234")
                .build();
        personRepository.save(p1);

        Person p2 = Person.builder()
                .email("Smith@gmail.com")
                .name("Smith")
                .password("1234")
                .build();
        personRepository.save(p2);

        assertThat(personRepository.count()).isEqualTo(2);
    }
}
