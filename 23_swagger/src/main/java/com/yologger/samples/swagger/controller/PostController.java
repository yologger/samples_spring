package com.yologger.samples.swagger.controller;

import com.yologger.samples.swagger.model.AddPostRequest;
import com.yologger.samples.swagger.model.Post;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "게시글 관련 엔드포인트")
public class PostController {

    @GetMapping("/post/{post_id}")
    @ApiImplicitParams({
        @ApiImplicitParam(
            name = "post_id",
            value = "사용자 아이디",
            required = true,
            dataType = "Long",  // 기본 타입 | 클래스 이름
            paramType = "path", // path | query | body | header | form
            defaultValue = "0")
    })
    public Post getPost(
            // @ApiParam(value = "작성자 아이디", required = true)
            @PathVariable("post_id") Long postId
    ) {
        Post post = Post.builder()
                .id(postId)
                .title("title")
                .content("content")
                .build();

        return post;
    }

    @ApiOperation(
            value = "게시글 추가",
            notes = "게시글 추가하기"
    )
    @PostMapping("/post")
    public Long addPost(
            @ApiParam(value = "게시글 정보", required = true)
            @RequestBody AddPostRequest request
    ) {
        return request.getWriterId();
    }
}
