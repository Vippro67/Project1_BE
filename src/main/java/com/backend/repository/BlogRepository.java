package com.backend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.backend.entity.Blog;

public interface BlogRepository extends MongoRepository<Blog, String> {

    List<Blog> findByTag(String tag);

}
