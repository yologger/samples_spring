package com.yologger.spring_mongodb.data;

import com.yologger.spring_mongodb.base.BaseDocument;
import lombok.Builder;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "member")
@Getter
public class MemberDocument extends BaseDocument {

    @Id
    private ObjectId id;

    @Field
    private String email;

    @Field
    private String password;

    @Field
    @DBRef
    private List<PostDocument> posts = new ArrayList<PostDocument>();

    @Builder
    public MemberDocument(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void addPost(PostDocument post) {
        this.posts.add(post);
    }
}
