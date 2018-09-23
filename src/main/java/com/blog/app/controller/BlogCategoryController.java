package com.blog.app.controller;

import com.blog.app.domain.BlogCategory;
import com.blog.app.service.BlogCategoryService;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/blogCategory")
public class BlogCategoryController {

    // 日志追踪器
    private static Logger logger = LoggerFactory.getLogger(BlogCategoryController.class);

    @Resource
    private BlogCategoryService blogCategoryService = null;

    @RequestMapping(method = RequestMethod.GET)
    public List<BlogCategory> getBlogCategory() {
        List<BlogCategory> blogCategoryList = new ArrayList<BlogCategory>();
        try{
            blogCategoryList = blogCategoryService.findBlogCategory();
        } catch (Exception e){
            logger.error("查询博客类型！", e);
        }
        return blogCategoryList;
    }
}
