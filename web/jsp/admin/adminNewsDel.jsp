<%@ page import="com.kgc.news.dao.NewsDao" %>
<%@ page import="com.kgc.news.impl.NewsDaoImpl" %>
<%@ page import="com.kgc.news.service.NewsService" %>
<%@ page import="com.kgc.news.pojo.NewsDetails" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/3/28
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../../common/common.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--给页面为删除新闻的处理--%>
    <%--1、获取要删除新闻的id    2、调用后台方法，根据id将该新闻删除--%>
    <%
        int id = Integer.parseInt(request.getParameter("id"));

        NewsDetails news = new NewsDetails();
        news.setId(id);
        String flag = "failed";

        if(newsService.deleteNews(news)>0){
            flag = "success";
        }
        response.sendRedirect("newsDetailList.jsp?flag="+flag);

    %>



</body>
</html>
