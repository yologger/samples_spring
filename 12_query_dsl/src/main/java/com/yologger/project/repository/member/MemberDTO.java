package com.yologger.project.repository.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MemberDTO {
    private String email;
    private Integer age;
    private String nation;
    private String gender;

    @Builder
    public MemberDTO(String email, Integer age, String nation, String gender) {
        this.email = email;
        this.age = age;
        this.nation = nation;
        this.gender = gender;
    }
}
