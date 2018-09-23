package com.blog.app.service.impl;

import com.blog.app.dao.BlogCategoryDao;
import com.blog.app.domain.BlogCategory;
import com.blog.app.service.BlogCategoryService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlogCategoryServiceImpl implements BlogCategoryService {

    @Resource
    private BlogCategoryDao blogCategoryDao;

    @Override
    public List<BlogCategory> findBlogCategory(){
        if(blogCategoryDao != null) {
            return blogCategoryDao.findAll();
        }
        return null;
    }
}
