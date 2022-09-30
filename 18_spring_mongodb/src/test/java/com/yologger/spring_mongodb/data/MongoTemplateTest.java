package com.yologger.spring_mongodb.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.transaction.annotation.Transactional;

import static com.google.common.truth.Truth.assertThat;

@DataMongoTest
class MongoTemplateTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void savePost() {

        PostDocument post = PostDocument.builder()
                .title("title1")
                .content("content1")
                .build();

        mongoTemplate.insert(post);

        assertThat(mongoTemplate.findAll(PostDocument.class, "post").size()).isEqualTo(1);
    }

}