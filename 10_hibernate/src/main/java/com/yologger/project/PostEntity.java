package com.yologger.project;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class PostEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "writer_id")
    private MemberEntity writer;

    public PostEntity(String content) {
        this.content = content;
    }

    public PostEntity() {

    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public MemberEntity getWriter() {
        return writer;
    }

    public void setWriter(MemberEntity writer) {
        this.writer = writer;
    }
}
