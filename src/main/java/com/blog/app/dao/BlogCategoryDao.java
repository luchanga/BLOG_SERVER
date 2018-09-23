package com.blog.app.dao;

import com.blog.app.domain.BlogCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BlogCategoryDao extends CrudRepository<BlogCategory, String> {

    public List<BlogCategory> findAll();
}
