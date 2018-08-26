package com.blog.app.service.impl;

import com.blog.app.dao.BloggerDao;
import com.blog.app.domain.Blogger;
import com.blog.app.service.BloggerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BloggerServiceImpl implements BloggerService {

    @Resource
    private BloggerDao bloggerDao;

    @Override
    public Blogger getBloggerByUserName(String userName) {
        if(bloggerDao != null) {
            return bloggerDao.findBloggerByUsername(userName);
        }
        return null;
    }
}
