package com.yologger.samples.spring_data_mongodb.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
public class MongoTemplateTest {

    @Autowired private MongoTemplate mongoTemplate;

    @Test
    public void test() {
        String title = "title";
        String content = "content";

        PostDocument post = PostDocument.builder()
                .title(title)
                .content(content)
                .build();

        PostDocument saved = mongoTemplate.save(post);
        assertThat(saved.getTitle()).isEqualTo(title);
    }
}
