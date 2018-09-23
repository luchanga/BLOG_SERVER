package com.blog.app.service;

import com.blog.app.domain.Blog;

import java.util.List;

public interface BlogService {

    // 查询博客
    public List<Blog> getAllBlog();

    // 保存
    public Blog saveBlog(Blog blog);

    // 删除
    public void deleteBlogById(String id);

    // 模糊查询
    public List<Blog> findBlogByTitleLike(String title);
}
