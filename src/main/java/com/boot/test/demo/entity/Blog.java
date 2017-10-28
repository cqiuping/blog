package com.boot.test.demo.entity;

import java.util.Date;

/**
 * @Description
 * @Author <a href="mailto:chengqiuping@wxchina.com ">qiuping.Cheng</a>
 * @Date 2017/10/12
 * @Version 1.0.0
 */
public class Blog {
    private int id;
    private String title;
    private String summary;
    private String content;
    private Date createTime;
    private int categoryId;
    private int hits;
    private String imageUrl;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getContent() {
        return content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public int getHits() {
        return hits;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
