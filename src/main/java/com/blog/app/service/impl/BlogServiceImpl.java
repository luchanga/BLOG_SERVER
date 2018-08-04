package com.blog.app.service.impl;

import com.blog.app.dao.BlogDao;
import com.blog.app.domain.Blog;
import com.blog.app.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogDao blogDao = null;

    @Override
    public List<Blog> getAllBlog () {
        if (blogDao != null){
            return blogDao.findAll();
        }
        return null;
    }

    @Override
    public Blog saveBlog(Blog blog) {
        if(blogDao != null) {
            blogDao.save(blog);
        }
        return blog;
    }

    @Override
    public void deleteBlogById(String id) {
        if(blogDao != null) {
            blogDao.deleteBlogById(id);
        }
    }

}
