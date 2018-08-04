package com.blog.app.domain;

//import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "blog_category")
public class BlogCategory {

    @Id
    @GeneratedValue(generator = "generator")
    private String id;

    @Column(name = "category_name")
    private String categoryName; // 种类名称

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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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
