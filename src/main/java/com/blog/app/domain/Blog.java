package com.blog.app.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BLOG")
public class Blog {

    @Id
    @GeneratedValue(generator="generator")
    @GenericGenerator(name="generator",strategy="uuid")
    private String id;

    @Column(name = "title")
    private String title; // 标题

    @Column(name = "bloginfo")
    private String bloginfo; // 博客信息

    @Column(name = "readtimes")
    private int readtimes; // 浏览次数

    @Column(name = "kinds")
    private String kinds; // 种类

    @Column(name = "content")
    private String content; // 内容

    @Column(name = "createtime")
    private Date createtime; // 创建时间

    @Column(name = "updatetime")
    private Date updatetime; // 更新时间

    @Column(name = "createuser")
    private String createuser; // 创建人

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBloginfo() {
        return bloginfo;
    }

    public void setBloginfo(String bloginfo) {
        this.bloginfo = bloginfo;
    }

    public int getReadtimes() {
        return readtimes;
    }

    public void setReadtimes(int readtimes) {
        this.readtimes = readtimes;
    }

    public String getKinds() {
        return kinds;
    }

    public void setKinds(String kinds) {
        this.kinds = kinds;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }
}
