package com.blog.app.dao;

import com.blog.app.domain.Blog;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BlogDao extends CrudRepository<Blog, String> {

    // 查询博客
    public List<Blog> findAll();
}
