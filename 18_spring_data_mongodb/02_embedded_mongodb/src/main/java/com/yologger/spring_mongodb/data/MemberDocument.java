package com.yologger.spring_mongodb.data;

import com.yologger.spring_mongodb.base.BaseDocument;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "member")
@Getter
public class MemberDocument extends BaseDocument {

    @Id
    private String id;

    @Field
    private String email;

    @Field
    private String password;

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
