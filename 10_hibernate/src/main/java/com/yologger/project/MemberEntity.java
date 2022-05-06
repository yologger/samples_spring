package com.yologger.project;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name= "member")
public class MemberEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @OneToMany(mappedBy = "writer", fetch = FetchType.LAZY)
    private Map<String, PostEntity> posts = new HashMap();

    public MemberEntity() {
    }

    public MemberEntity(String email) {
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, PostEntity> getPosts() {
        return this.posts;
    }
}
