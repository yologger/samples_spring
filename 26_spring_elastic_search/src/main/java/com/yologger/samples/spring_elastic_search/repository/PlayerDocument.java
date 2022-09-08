package com.yologger.samples.spring_elastic_search.repository;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "player")
@Getter
@Builder
public class PlayerDocument {
    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Text)
    private String nation;

    @Field(type = FieldType.Integer)
    private int age;

    @Field(type = FieldType.Integer)
    private int score;

    @Field(type = FieldType.Integer)
    private int assist;
}
