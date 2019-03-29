<%@ page import="com.kgc.news.pojo.NewsDetails" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/3/23
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../common/common.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        NewsDetails newsDetails = new NewsDetails();
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String summary = request.getParameter("summary");
        String newscontent = request.getParameter("newscontent");

        newsDetails.setId(categoryId);
        newsDetails.setTitle(title);
        newsDetails.setAuthor(author);
        newsDetails.setSummary(summary);
        newsDetails.setContent(newscontent);
        newsDetails.setCreateDate(new Date());

        if(newsService.addNews(newsDetails)){
            %>
            <%--跳转到admin/newsDetailList.jsp--%>
            <jsp:forward page="../admin/newsDetailList.jsp"></jsp:forward>
        <%}else{%>
            新闻添加失败
        <%}%>

</body>
</html>
