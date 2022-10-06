package com.yologger.spring_mongodb.data;

import com.yologger.spring_mongodb.config.TestMongoConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
@Import(TestMongoConfig.class)
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @AfterEach
    void tearDown() {
        postRepository.deleteAll();
    }

    @Test
    void save_findAll() {

        String dummyTitle = "title";
        String dummyContent = "content";
        PostDocument post = PostDocument.builder()
                .title(dummyTitle)
                .content(dummyContent)
                .build();

        postRepository.save(post);

        List<PostDocument> posts = postRepository.findAll();
        assertThat(posts.size()).isEqualTo(1);
        assertThat(posts.get(0).getTitle()).isEqualTo(dummyTitle);
        assertThat(posts.get(0).getContent()).isEqualTo(dummyContent);
    }
}
