package com.yologger.project;

import javax.persistence.*;

@Entity
@Table(name= "post")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

    public PostEntity(String content) {
        this.content = content;
    }

    @ManyToOne
    private MemberEntity writer;

    public void setWriter(MemberEntity writer) {
        this.writer = writer;
        writer.getPosts().add(this);
    }

    public PostEntity() {

    }
}
