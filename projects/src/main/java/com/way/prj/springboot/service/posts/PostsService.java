package com.way.prj.springboot.service.posts;

import com.way.prj.springboot.domain.posts.Posts;
import com.way.prj.springboot.domain.posts.PostsRepository;
import com.way.prj.springboot.web.dto.PostsResponseDto;
import com.way.prj.springboot.web.dto.PostsSaveRequestDto;
import com.way.prj.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    @Autowired
    private final PostsRepository postsRepository;

    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }


    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findOne(id);
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById (Long id){
        Posts entity = postsRepository.findOne(id);
        return new PostsResponseDto(entity);
    }
}
