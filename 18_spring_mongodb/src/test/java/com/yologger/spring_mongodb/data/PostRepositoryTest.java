package com.yologger.spring_mongodb.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

@DataMongoTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    void test() {
        List<PostDocument> posts = postRepository.findAll();
        assertThat(posts.size()).isEqualTo(5);
    }
}
