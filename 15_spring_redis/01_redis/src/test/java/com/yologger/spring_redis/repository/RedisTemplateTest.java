package com.yologger.spring_redis.repository;

import com.yologger.spring_redis.config.TestRedisConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;

import java.util.List;
import java.util.Set;

import static com.google.common.truth.Truth.assertThat;

@DataRedisTest
@Import({TestRedisConfig.class})
class RedisTemplateTest {

    @Autowired
    RedisTemplate redisTemplate;

    @AfterEach
    public void tearDown() {
        redisTemplate.getConnectionFactory().getConnection().flushAll();
    }

    @Test
    @DisplayName("opsForValue() 테스트")
    public void opsForValue() {
        ValueOperations<String, String> operation = redisTemplate.opsForValue();
        operation.set("name", "Cristiano Ronaldo");

        String saved = operation.get("name");   // "Cristiano Ronaldo"
        assertThat(saved).isEqualTo("Cristiano Ronaldo");
    }

    @Test
    @DisplayName("opsForList() 테스트")
    public void opsForList() {
        ListOperations<String, String> operations =  redisTemplate.opsForList();
        operations.rightPush("players", "Ronaldo");
        operations.rightPushAll("players", "Messi", "Benzema", "Suarez");
        List<String> players = operations.range("players", 0, -1);  // ["Ronaldo", "Messi", "Benzema", "Suarez"]
        assertThat(players.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("opsForSet() 테스트")
    public void opsForSet() {
        SetOperations<String, String> operations =  redisTemplate.opsForSet();

        // Set에 요소 하나 추가
        operations.add("players", "Paul");

        // Set에 요소 여러 개 추가
        operations.add("players", "John", "Mike", "Monica");

        // Set 조회
        Set<String> players =  operations.members("players");

        assertThat(players.size()).isEqualTo(4);
    }
}
