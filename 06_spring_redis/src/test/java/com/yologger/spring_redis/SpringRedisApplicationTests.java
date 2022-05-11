package com.yologger.spring_redis;

import com.yologger.spring_redis.repository.Person;
import com.yologger.spring_redis.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import static com.google.common.truth.Truth.assertThat;

@DataRedisTest
class SpringRedisApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    PersonRepository personRepository;


    @Test
    public void test1() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());

        ValueOperations<String, String> operation = redisTemplate.opsForValue();
        operation.set("name", "Cristiano Ronaldo");

        String saved = operation.get("name");   // "Cristiano Ronaldo"
        assertThat(saved).isEqualTo("Cristiano Ronaldo");
    }

    @Test
    public void test2() {
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
