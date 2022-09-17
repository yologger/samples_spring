package com.yologger.samples.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@ApiModel(
    value = "게시물 정보",
    description = "작성자 아이디, 제목, 내용을 포함하는 게시물 작성 정보"
)
public class AddPostRequest {

    @JsonProperty("writer_id")
    @ApiModelProperty(value = "작성자 아이디", example = "1")
    private Long writerId;
    @ApiModelProperty(value = "게시글 제목", example = "This is title")
    private String title;
    @ApiModelProperty(value = "게시글 내용", example = "This is content.")
    private String content;

    @Builder
    public AddPostRequest(Long writerId, String title, String content) {
        this.writerId = writerId;
        this.title = title;
        this.content = content;
    }
}
