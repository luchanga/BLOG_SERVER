package com.blog.app.dao;

import com.blog.app.domain.Blog;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BlogDao extends CrudRepository<Blog, String> {

    // 查询博客
    public List<Blog> findAll();

    // 删除博客
    public void deleteBlogById(String id);

    // 模糊查询
    public List<Blog> findBlogByTitleLike(String title);

}
