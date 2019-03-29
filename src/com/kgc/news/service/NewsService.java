package com.kgc.news.service;

import com.kgc.news.pojo.NewsDetails;

import java.util.List;

/**
 * @author Mr.5227
 * @date 2019/3/23 - 8:57
 */
public interface NewsService {
    //获取新闻信息
    public List<NewsDetails> getNewsDetails();
    public boolean addNews(NewsDetails newsDetails);
    //通过Id查询新闻详情
    public NewsDetails getNewsById(int id);
    //删除新闻
    public int deleteNews(NewsDetails news);
    //查询新闻总条数
    public int getTotalCount();
    //查询分页数据 pageNo 当前页码，pageSize 页面容量
    public List<NewsDetails> getPageNewsList(int pageNo,int pageSize);



}
