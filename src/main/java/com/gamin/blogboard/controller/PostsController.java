package com.gamin.blogboard.controller;

import com.gamin.blogboard.config.CustomModelMapper;
import com.gamin.blogboard.dto.ModifyPostsDto;
import com.gamin.blogboard.dto.PostsResDto;
import com.gamin.blogboard.dto.RegistPostsDto;
import com.gamin.blogboard.entity.Posts;
import com.gamin.blogboard.repository.PostsRepository;
import com.gamin.blogboard.services.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = {"/posts"}, produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class PostsController {

    private PostsService postsService;

    /**
     * @method 설명 : 게시글 목록조회
     * @throws Exception
     */
    @GetMapping(value = {""})
    public ResponseEntity<List<PostsResDto>> getPosts() {
        return ResponseEntity.ok()
                .body(postsService.getPostsService());
    }

    /**
     * @method 설명 : 게시글 등록
     * @param regPosts
     * @throws Exception
     */
    @PostMapping(value = {""})
    public ResponseEntity<Long> regPosts(@Valid @RequestBody RegistPostsDto regPosts) throws Exception {
        return ResponseEntity.ok()
                .body(postsService.regPostsService(regPosts));
    }

    /**
     * @method 설명 : 게시글 상세조회
     * @param id
     * @return
     */
    @GetMapping(value = {"/{id}"})
    public ResponseEntity<PostsResDto> getPostsDetail(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(postsService.getPostsByIdService(id));
    }

    /**
     * @method 설명 : 게시글 수정
     * @param id
     * @param setPosts
     * @throws Exception
     */
    @PutMapping(value = {"/{id}"})
    public ResponseEntity<String> setPosts(
            @PathVariable Long id,
            @Valid @RequestBody ModifyPostsDto setPosts) throws Exception {

        postsService.setPostsService(setPosts);

        return ResponseEntity.ok()
                .body("UPDATE SUCCESS");
    }

    /**
     * @method 설명 : 게시글 삭제
     * @param id
     * @throws Exception
     */
    @DeleteMapping(value = {"/{id}"})
    public ResponseEntity<String> delPosts(
            @PathVariable Long id) throws Exception {

        postsService.delPostsService(id);

        return ResponseEntity.ok()
                .body("DELETE SUCCESS");
    }

}