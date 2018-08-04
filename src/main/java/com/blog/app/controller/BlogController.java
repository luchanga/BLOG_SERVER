package com.blog.app.controller;

import com.blog.app.domain.Blog;
import com.blog.app.domain.ResponseObject;
import com.blog.app.service.BlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

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

    // 查询博客
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

    // 新增博客
    @RequestMapping(value = "/addBlog", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseObject addBlog(@RequestBody Blog blog) {
        ResponseObject object = new ResponseObject();
        try{
            blogService.saveBlog(blog);
            object.setId(blog.getId());
        } catch (Exception e){
            logger.error("新增失败！", e);
            object.setError("error");
        }
        return object;
    }

    // 删除博客
    @RequestMapping(value = "/deleteBlog", method = RequestMethod.DELETE)
    public
    @ResponseBody
    ResponseObject deleteBlog(@RequestParam("id") String id) {
        ResponseObject object = new ResponseObject();
        try {
            blogService.deleteBlogById(id);
            object.setId(id);
        } catch (Exception e){
            logger.error("删除失败！", e);
            object.setError("error");
        }
        return object;
    }
}
