package com.yologger.spring_mongodb.data;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static com.google.common.truth.Truth.assertThat;

@DataMongoTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void test() {
        MemberDocument member1 = MemberDocument.builder()
                .email("Paul@gmai.com")
                .name("Paul")
                .age(25)
                .isMarried(true)
                .weight(170.3)
                .build();

        MemberDocument member2 = MemberDocument.builder()
                .email("Monica@gmai.com")
                .name("Monica")
                .age(33)
                .isMarried(false)
                .weight(150.8)
                .build();

        memberRepository.save(member1);
        memberRepository.save(member2);

        assertThat(memberRepository.count()).isEqualTo(2);
    }
}