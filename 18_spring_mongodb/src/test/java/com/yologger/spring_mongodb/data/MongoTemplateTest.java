package com.yologger.spring_mongodb.data;

import com.yologger.spring_mongodb.config.TestMongoConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;

import static com.google.common.truth.Truth.assertThat;

@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
@Import(TestMongoConfig.class)
class MongoTemplateTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @AfterEach
    public void tearDown() {
        mongoTemplate.dropCollection("post");
    }

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