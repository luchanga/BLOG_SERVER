package com.blog.app.controller;

import com.blog.app.domain.Blog;
import com.blog.app.service.BlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    // 日志追踪器
    private static Logger logger = LoggerFactory.getLogger(BlogController.class);


    @Resource
    private BlogService blogService = null;

    @RequestMapping(value = "/getBlog", method = RequestMethod.GET)
    public List<Blog> getBlog () {
        List<Blog> blogs = new ArrayList<Blog>();
        try{
            blogs = blogService.getAllBlog();
        } catch (Exception e) {
            logger.error("查询失败！", e);
        }
        return blogs;
    }

}
