package com.kgc.news.impl;

import com.kgc.news.dao.BaseDao;
import com.kgc.news.dao.NewsDao;
import com.kgc.news.pojo.NewsDetails;
import com.kgc.news.service.NewsService;

import java.util.List;

/**
 * @author Mr.5227
 * @date 2019/3/23 - 8:59
 */
public class newsServiceImpl implements NewsService {
    private NewsDao newsDao;    //新闻Dao属性
    public newsServiceImpl(){
        newsDao = new NewsDaoImpl();    //生成一个newsDao对象
    }
    //获取新闻列表
    @Override
    public List<NewsDetails> getNewsDetails() {

        return newsDao.getNewsDetails();
    }

    @Override
    public boolean addNews(NewsDetails news) {
        boolean flag = false;
        String sql = "insert into news_detail(categoryId,title,author,summary,content,createDate,picPath) value(?,?,?,?,?,?,?)";
        Object[] params = {news.getCategoryId(),news.getTitle(),news.getAuthor(),news.getSummary(),news.getContent(),news.getCreateDate(),news.getPicPath()};
        BaseDao baseDao = new BaseDao();
        int i = baseDao.executeUpdate(sql,params);
        if(i>0){
            flag = true;
        }
        baseDao.closeAll();
        return flag;
    }

    @Override
    public NewsDetails getNewsById(int id) {
        return newsDao.getNewsById(id);
    }

    @Override
    public int deleteNews(NewsDetails news) {
        return newsDao.deleteNews(news);
    }

    @Override
    public int getTotalCount() {
        return newsDao.getTotalCount();
    }

    @Override
    public List<NewsDetails> getPageNewsList(int pageNo, int pageSize) {
        return newsDao.getPageNewsList(pageNo,pageSize);
    }
}
