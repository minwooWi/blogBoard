package com.gamin.blogboard.repository;

import com.gamin.blogboard.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {


}