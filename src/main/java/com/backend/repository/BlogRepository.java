package com.backend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.backend.entity.Blog;

public interface BlogRepository extends MongoRepository<Blog, String> {

    @Query("{'tag' : ?0}")
    List<Blog> findByTag(String tag);


    @Query("{'title': {$regex: '(?i).*?0.*'}}")
    List<Blog> findByTitle(String yourSearchTerm);
}
