package com.yologger.spring_redis.repository;

import com.yologger.spring_redis.config.TestRedisConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.*;

import java.util.List;
import java.util.Map;
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

        String redisKey = "Phone";

        ValueOperations<String, Phone> operation = redisTemplate.opsForValue();
        String phoneName = "iPhone 11";
        Phone p = new Phone(phoneName);
        operation.set(redisKey, p);

        Phone saved = operation.get(redisKey);   // "Cristiano Ronaldo"
        assertThat(saved.getName()).isEqualTo(phoneName);
    }

    @Test
    @DisplayName("opsForList() 테스트")
    public void opsForList() {

        String redisKey = "Phone";

        Phone p1 = new Phone("iPhone11");
        Phone p2 = new Phone("Galaxy1");
        Phone p3 = new Phone("Galaxy2");
        Phone p4 = new Phone("Galaxy3");

        ListOperations<String, Phone> operations =  redisTemplate.opsForList();
        operations.rightPush(redisKey, p1);
        operations.rightPushAll(redisKey, p2, p3, p4);
        List<Phone> phones = operations.range(redisKey, 0, -1);  // ["Ronaldo", "Messi", "Benzema", "Suarez"]
        assertThat(phones.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("opsForSet() 테스트")
    public void opsForSet() {

        String redisKey = "Phone";

        Phone p1 = new Phone("iPhone11");
        Phone p2 = new Phone("Galaxy1");
        Phone p3 = new Phone("Galaxy2");
        Phone p4 = new Phone("Galaxy3");

        SetOperations<String, Phone> operations =  redisTemplate.opsForSet();

        // Set에 요소 하나 추가
        operations.add(redisKey, p1);

        // Set에 요소 여러 개 추가
        operations.add(redisKey, p2, p3, p4);

        // Set 조회
        Set<Phone> phones =  operations.members(redisKey);

        assertThat(phones.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("opsForHash() 테스트")
    public void opsForHash() {

        String redisKey = "Phone";

        Phone p1 = new Phone("iPhone11");
        Phone p2 = new Phone("Galaxy1");
        Phone p3 = new Phone("Galaxy2");

        HashOperations<String, String, Phone> operations =  redisTemplate.opsForHash();

        operations.put(redisKey, p1.getId(), p1);
        operations.put(redisKey, p2.getId(), p2);
        operations.put(redisKey, p3.getId(), p3);

        Map<String, Phone> phones = operations.entries(redisKey);
        assertThat(phones.size()).isEqualTo(3);
    }
}


