package com.yologger.samples.swagger.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Post {
    private Long id;
    private String title;
    private  String content;

    @Builder
    public Post(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
