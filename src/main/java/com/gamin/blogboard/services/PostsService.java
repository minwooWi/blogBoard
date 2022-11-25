package com.gamin.blogboard.services;

import com.gamin.blogboard.config.CustomModelMapper;
import com.gamin.blogboard.dto.ModifyPostsDto;
import com.gamin.blogboard.dto.PostsResDto;
import com.gamin.blogboard.dto.RegistPostsDto;
import com.gamin.blogboard.entity.Posts;
import com.gamin.blogboard.repository.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service("postsService")
@AllArgsConstructor
public class PostsService {

    private PostsRepository postsRepository;

    private CustomModelMapper customModelMapper;

    // 글 목록 조회
    public List<PostsResDto> getPostsService() {

        List<Posts> entityList = postsRepository.findAll();

        return entityList.stream()
                .map(entity -> customModelMapper.toDto(entity, PostsResDto.class))
                .collect(Collectors.toList());
    }

    // 글 등록
    public Long regPostsService(RegistPostsDto regPosts) {

        Long insertId = postsRepository.save(regPosts.toEntity()).getId();

        return insertId;
    }

    // 글 상세 조회
    public PostsResDto getPostsByIdService(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow();

        return customModelMapper.toDto(entity, PostsResDto.class);
    }

    // 글 수정
    public void setPostsService(ModifyPostsDto setPosts) {
        postsRepository.save(setPosts.toEntity());
    }

    // 글 삭제
    public void delPostsService(Long id) {
        postsRepository.deleteById(id);
    }

}