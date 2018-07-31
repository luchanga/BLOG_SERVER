package com.blog.app.service;

import com.blog.app.domain.Blog;

import java.util.List;

public interface BlogService {

    // 查询博客
    public List<Blog> getAllBlog();
}
