package com.yologger.spring_mongodb.data;

import com.yologger.spring_mongodb.base.BaseDocument;
import lombok.Builder;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "member")
@Getter
public class MemberDocument extends BaseDocument {

    @Id
    private ObjectId id;

    @Field
    private String email;

    @Field
    private String name;

    @Field(name="is_married")
    private Boolean isMarried;

    @Field
    private Integer age;

    @Field
    private Double weight;

    @Builder
    public MemberDocument(String email, String name, Boolean isMarried, Integer age, Double weight) {
        this.email = email;
        this.name = name;
        this.isMarried = isMarried;
        this.age = age;
        this.weight = weight;
    }
}
