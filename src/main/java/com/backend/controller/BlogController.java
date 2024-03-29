package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.entity.Blog;
import com.backend.service.BlogService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping()
    public List<Blog> getAllBlogs(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size) {
        return blogService.getAllBlogs(page, size);
    }
    @GetMapping("/id/{id}")
    public Blog getBlogById(@PathVariable String id) {
        return blogService.getBlogById(id);
    }
    @GetMapping("/title/{title}")
    public List<Blog> getBlogsByTitle(@PathVariable String title) {
        return blogService.getBlogsByTitle(title);
    }
    @GetMapping("/tag/{tag}")
    public List<Blog> getBlogsByTag(@PathVariable String tag) {
        return blogService.getBlogsByTag(tag);
    }

    @PostMapping
    public Blog createBlog(@RequestBody Blog blog) {
        return blogService.createBlog(blog);
    }

    @PutMapping("/{id}")
    public Blog updateBlog(@PathVariable String id, @RequestBody Blog blog) {
        return blogService.updateBlog(id, blog);
    }

    @DeleteMapping("/{id}")
    public String deleteBlog(@PathVariable String id) {
        return blogService.deleteBlog(id);
    }
}
