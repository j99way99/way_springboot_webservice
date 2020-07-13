package com.way.prj.springboot.web;

import com.way.prj.springboot.service.posts.PostsService;
import com.way.prj.springboot.web.dto.PostsRequestDto;
import com.way.prj.springboot.web.dto.PostsResponseDto;
import com.way.prj.springboot.web.dto.PostsSaveRequestDto;
import com.way.prj.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    @Autowired
    private final PostsService postsService;

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);

    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    @PutMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }
}
