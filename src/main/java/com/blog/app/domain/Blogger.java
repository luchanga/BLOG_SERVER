package com.blog.app.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "blogger")
public class Blogger {

    @Id
    @GeneratedValue(generator="generator")
    @GenericGenerator(name="generator",strategy="uuid")
    private String id;

    @Column(name = "username")
    private String username; // 用户名

    @Column(name = "headimage")
    private String headimage; // 头像

    @Column(name = "password")
    private String password; // 密码

    @Column(name = "gender")
    private String gender; // 性别

    @Column(name = "age")
    private int age; // 年龄

    @Column(name = "profession")
    private String profession; // 职业

    @Column(name = "telephone")
    private int telephone; // 电话号码

    @Column(name = "email")
    private String email; // 电子邮箱

    @Column(name = "introduction")
    private String introduction; // 介绍

    @Column(name = "createtime")
    private Date createtime; // 创建时间

    @Column(name = "updatetime")
    private Date updatetime; // 更新时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHeadimage() {
        return headimage;
    }

    public void setHeadimage(String headimage) {
        this.headimage = headimage;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
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
}
