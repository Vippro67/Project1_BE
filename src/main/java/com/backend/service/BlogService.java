package com.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.backend.entity.Blog;
import com.backend.repository.BlogRepository;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;
    public Object getBlogById;

    public List<Blog> getAllBlogs(int page, int size) {
    Pageable pageable = PageRequest.of(page - 1, size);
    Page<Blog> blogPage = blogRepository.findAll(pageable);
    return blogPage.getContent();
}
    public Blog getBlogById(String id) {
        return blogRepository.findById(id).get();
    }
    public List<Blog> getBlogsByTag(String tag) {
        return blogRepository.findByTag(tag);
    }
    public List<Blog> getBlogsByTitle(String title) {
        return blogRepository.findByTitle(title);
    }

    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
        } 
}
