package com.yologger.global_cache.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateEmailByIdRequest {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "password")
    private String password;
}

