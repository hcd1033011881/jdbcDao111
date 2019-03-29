package com.kgc.news.impl;

import com.kgc.news.dao.BaseDao;
import com.kgc.news.dao.NewsDao;
import com.kgc.news.pojo.NewsDetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Mr.5227
 * @date 2019/3/20 - 10:38
 */
public class NewsDaoImpl extends BaseDao implements NewsDao {
    //查询数据
    @Override
    public List<NewsDetails> getNewsDetails() {
        //创建一个存放数据对象的集合
        List<NewsDetails> list = new ArrayList<>();
        String sql = "select * from news_detail";
        Object [] params = {};  //创建一个存放参数的数组
        ResultSet rs = executeSelect(sql,params);
        while (true){
            int id;
            String title;
            String author;
            Date createDate;
            String picPath;
            NewsDetails news = new NewsDetails();
            try {
                if (!rs.next()) break;
                id = rs.getInt("id");
                title = rs.getString("title");
                author = rs.getString("author");
                picPath = rs.getString("picPath");
                createDate = rs.getDate("createDate");
                news.setId(id);
                news.setTitle(title);
                news.setAuthor(author);
                news.setCreateDate(createDate);
                news.setPicPath(picPath);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            list.add(news);
        }
        closeAll();
        return list;
    }

    //插入数据
    @Override
    public int addNews(NewsDetails news) {
        String sql = "insert into news_detail(id,title,author,createDate,picPath) value(?,?,?,?,?)";
        Object[] params = {news.getId(),news.getTitle(),news.getAuthor(),news.getCreateDate(),news.getPicPath()};

//        Object[] params = {1,"java","hcd","2019-03-16 12:22:00"};
        int i = executeUpdate(sql,params);
        System.out.println("受影响的行数"+i);

        if(i>0){
            System.out.println("插入数据成功！");
        }
        closeAll();
        return i;
    }

    //删除数据
    @Override
    public int deleteNews(NewsDetails news) {
        String sql = "delete from news_detail where id = ?";
        Object[] params = {news.getId()};
        int i = executeUpdate(sql,params);
        if(i>0){
            System.out.println("删除数据成功！");
        }
        closeAll();
        return i;
    }

    //修改数据
    @Override
    public int updateNews(NewsDetails news) {
        String sql = "update news_detail set author='ls' where id = ?";
        Object[] params = {news.getId()};
        int i = executeUpdate(sql,params);
        if(i>0){
            System.out.println("修改数据成功！");
        }
        closeAll();
        return i;
    }

    //通过id获取新闻详情
    @Override
    public NewsDetails getNewsById(int id) {
        NewsDetails newsDetails = new NewsDetails();
        String sql = "select * from news_detail where id = ?";
        Object[] params = {id};
        ResultSet rs = executeSelect(sql,params);
        try {
            if(rs.next()){
                newsDetails.setId(rs.getInt("id"));
                newsDetails.setTitle(rs.getString("title"));
                newsDetails.setSummary(rs.getString("summary"));
                newsDetails.setContent(rs.getString("content"));
                newsDetails.setAuthor(rs.getString("author"));
                newsDetails.setCreateDate(rs.getDate("createDate"));
                newsDetails.setPicPath(rs.getString("picPath"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return newsDetails;
    }

    //获取查询数据的总条数
    @Override
    public int getTotalCount() {
        String sql = "select count(1) from news_detail";
        Object[] params = {};
        int count = 0;
        ResultSet rs = executeSelect(sql,params);
        try {
            if(rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return count;
    }

    @Override
    public List<NewsDetails> getPageNewsList(int pageNo, int pageSize) {
        List<NewsDetails> list = new ArrayList<>();
        ResultSet rs = null;
        String sql = "select * from news_detail order by createDate desc limit ?,?";
        Object[] params = {(pageNo-1)*pageSize,pageSize};
        rs = executeSelect(sql,params);
        try {
            while(rs.next()){
                NewsDetails news = new NewsDetails();
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String summary = rs.getString("summary");
                String content = rs.getString("content");
                Date createDate = rs.getDate("createDate");
                news.setId(id);
                news.setTitle(title);
                news.setAuthor(author);
                news.setCreateDate(createDate);
                news.setContent(content);
                news.setSummary(summary);

                list.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return list;
    }
}
