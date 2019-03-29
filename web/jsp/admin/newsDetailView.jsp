<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.kgc.news.pojo.NewsDetails"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../common/common.jsp" %>
<html>
	<head>
		<link href="<%=request.getContextPath() %>/css/common.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=request.getContextPath() %>/ckeditor/ckeditor.js"> </script>
	</head>
<body>
<div class="main-content-right">
      
        <div class="main-text-box">
      		<div class="main-text-box-tbg">
                <div class="main-text-box-bbg">
                    <div class="article-box">
                    	<!--新闻的标题-->
                        <%
                            int id = Integer.parseInt(request.getParameter("id"));
                            NewsDetails newsDetails = newsService.getNewsById(id);
                            request.setAttribute("news",newsDetails);
                        %>
                        传过来的id${param.id}
                        <%--<h1><%=newsDetails.getTitle()%></h1>--%>
                        <h1>${news.title}</h1>
                        <%--<div class="source-bar">发布者：<%=newsDetails.getAuthor()%> 分类：新闻信息 更新时间：<%=newsDetails.getCreateDate()%> </div>--%>
                        <div class="source-bar">发布者：${news.author} 分类：新闻信息 更新时间：${news.createDate} </div>
                        <div class="article-content">
                            <span class="article-summary"><b>摘要：${news.summary}</b></span>
                                新闻内容：${news.content}<br/>
                                新闻图片：<img src="<%=request.getContextPath()%>/upload/${news.picPath}" alt="">
                         </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
