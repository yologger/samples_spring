package com.yologger.spring_mongodb.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import static com.google.common.truth.Truth.assertThat;

@DataMongoTest
class MemberRepositoryTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void test() {

        MemberDocument member = MemberDocument.builder()
                .email("Son@gmai.com")
                .password("1234")
                .build();

        PostDocument post1 = PostDocument.builder()
                .title("title1")
                .content("content1")
                .build();

        member.addPost(post1);

        PostDocument post2 = PostDocument.builder()
                .title("title2")
                .content("content2")
                .build();

        member.addPost(post1);

        mongoTemplate.insert(member, "member");

        assertThat(mongoTemplate.findAll(MemberDocument.class, "member").size()).isEqualTo(1);
    }

}