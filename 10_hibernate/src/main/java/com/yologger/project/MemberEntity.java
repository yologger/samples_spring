package com.yologger.project;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name= "member")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String password;

    @OneToMany(mappedBy = "writer", cascade = CascadeType.PERSIST)
    private List<PostEntity> posts = new ArrayList<>();

    public MemberEntity(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public MemberEntity() {

    }

    public void addPost(PostEntity post) {
        this.posts.add(post);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public List<PostEntity> getPosts() {
        return posts;
    }
}
