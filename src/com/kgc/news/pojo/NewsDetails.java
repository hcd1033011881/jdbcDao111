package com.kgc.news.pojo;
import java.util.Date;

/**
 * @author Mr.5227
 * @date 2019/3/19 - 9:17
 */
public class NewsDetails {
    private int id; //新闻id
    private int categoryId; //类型id
    private String title;   //新闻标题
    private String summary; //新闻摘要
    private String content; //新闻内容
    private String picPath; //图片地址
    private String author;    //作者
    private Date createDate;    //修改日期

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }




}
