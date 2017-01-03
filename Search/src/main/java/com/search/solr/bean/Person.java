package com.search.solr.bean;

/**
 * Created by Administrator on 2016/12/23.
 */
public class Person {

    private Integer id;
    private String author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", author='" + author + '\'' +
                '}';
    }
}
