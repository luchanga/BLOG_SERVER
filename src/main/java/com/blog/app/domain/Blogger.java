package com.blog.app.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "blogger")
public class Blogger {

    @Id
    @GeneratedValue(generator="generator")
    @GenericGenerator(name="generator",strategy="uuid")
    private String id;
}
