package com.yologger.samples.spring_data_mongodb.data;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "member")
@Getter
public class MemberDocument {

    @Id
    private String id;

    @Field
    private String email;

    @Field
    private String password;

    @DBRef
    private List<PostDocument> posts = new ArrayList<>();

    @Builder
    public MemberDocument(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void addPost(PostDocument post) {
        this.posts.add(post);
    }
}
