package com.blog.app.dao;

import com.blog.app.domain.Blogger;
import org.springframework.data.repository.CrudRepository;

public interface BloggerDao extends CrudRepository<Blogger, String> {

    // 新增
//    public void saveBlogger
}
