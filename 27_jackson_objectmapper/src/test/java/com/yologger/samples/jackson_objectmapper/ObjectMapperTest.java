package com.yologger.samples.jackson_objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yologger.samples.jackson_objectmapper.model.Person;
import com.yologger.samples.jackson_objectmapper.model.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ObjectMapperTest {

    @Autowired private ObjectMapper objectMapper;

    @Test
    void test() throws JsonProcessingException {
        Post post = Post.builder()
                .title("this is title")
                .content("this is content")
                .build();

        String jsonStr = objectMapper.writeValueAsString(post);
        System.out.println(jsonStr);  // {"id":"8ba7d6bc-df70-4499-8fbb-a908a7fa675c","title":"this is title","content":"this is content","createdAt":"2022-10-07"}
    }
}
