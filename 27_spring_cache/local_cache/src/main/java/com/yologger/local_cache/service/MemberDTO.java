package com.yologger.local_cache.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yologger.local_cache.repository.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO implements Serializable {

    @JsonProperty("id") private Long id;
    @JsonProperty("email") private String email;
    @JsonProperty("password") private String password;

    public MemberEntity toEntity() {
        return MemberEntity.builder()
                .email(this.email)
                .password(this.password)
                .build();
    }
}
