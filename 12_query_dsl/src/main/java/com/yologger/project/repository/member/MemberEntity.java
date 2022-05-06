package com.yologger.project.repository.member;

import com.yologger.project.repository.post.PostEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "member")
@Getter
@NoArgsConstructor
public class MemberEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column
    private Integer age;

    @Column
    private String nation;

    @Column
    private String gender;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "writer")
    private List<PostEntity> posts;

    @Builder
    public MemberEntity(String email, String name, Integer age, String nation, String gender, String password) {
        this.email = email;
        this.name = name;
        this.age = age;
        this.nation = nation;
        this.gender = gender;
        this.password = password;
    }
}

