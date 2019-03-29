package com.kgc.news.dao;
import com.kgc.news.pojo.NewsDetails;

import java.util.List;

/**
 * @author Mr.5227
 * @date 2019/3/20 - 10:31
 * 新闻接口（所有的要设计的方法）
 */
public interface NewsDao {
    //获取所有的新闻详细信息
    public List<NewsDetails> getNewsDetails();
    //添加新闻
    public int addNews(NewsDetails news);
    //删除新闻
    public int deleteNews(NewsDetails news);
    //修改新闻
    public int updateNews(NewsDetails news);
    //通过Id查询新闻详情
    public NewsDetails getNewsById(int id);
    //查询新闻总条数
    public int getTotalCount();
    //查询分页数据 pageNo 当前页码，pageSize 页面容量
    public List<NewsDetails> getPageNewsList(int pageNo,int pageSize);

}
