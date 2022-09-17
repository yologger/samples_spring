package com.yologger.spring_mongodb.data;

import com.yologger.spring_mongodb.base.BaseDocument;
import lombok.Builder;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "post")
@Getter
public class PostDocument extends BaseDocument {

    @Id
    private ObjectId id;

    @Field
    private String title;

    @Field
    private String content;

    @Builder
    public PostDocument(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
