package com.yologger.samples.spring_data_mongodb.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
public class PostRepositoryTest {

    @Autowired PostRepository postRepository;
    @Autowired MemberRepository memberRepository;

    @Test
    void test() {
        PostDocument post1 = PostDocument.builder()
                .title("title1")
                .content("content1")
                .build();

        PostDocument saved1 = postRepository.save(post1);

        PostDocument post2 = PostDocument.builder()
                .title("title2")
                .content("content2")
                .build();

        PostDocument saved2 = postRepository.save(post2);

        MemberDocument member = MemberDocument.builder()
                .email("paul@gmail.com")
                .password("1234")
                .build();

        member.addPost(saved1);
        member.addPost(saved2);

        MemberDocument saved = memberRepository.save(member);
        assertThat(saved.getPosts().size()).isEqualTo(2);
    }
}
