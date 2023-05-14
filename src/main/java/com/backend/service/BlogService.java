package com.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.entity.Blog;
import com.backend.repository.BlogRepository;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }
    public List<Blog> getBlogsByTag(String tag) {
        return blogRepository.findByTag(tag);
    }

    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
        } 
}
