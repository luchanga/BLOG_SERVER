package com.blog.app.service;

import com.blog.app.domain.Blogger;

public interface BloggerService {

    public Blogger getBloggerByUserName(String userName);

}
