package com.way.prj.springboot.web.dto;

import com.way.prj.springboot.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsRequestDto {

    private String title;
    private String content;

    public PostsRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
