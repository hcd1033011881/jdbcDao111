<%@ page import="com.kgc.news.pojo.NewsDetails" %>
<%@ page import="java.util.List" %>
<%@ page import="util.PageUtil" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../common/common.jsp"%>

<%--JSTL标签库引入语句--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>无标题文档</title>
	<style type="text/css">	</style>
</head>
<body>
<!--主体-->
<script>
	function addNews() {
		window.location="newsDetailCreateSimple.jsp"
	}
	//删除新闻的提示
	var flag = "${param.flag}";
	if(flag != null && flag != '' && flag != undefined){
		if(flag=='success'){
			alert("删除成功！");
		}else{
			alert("删除失败！");
		}
	}
</script>
<div class="main-content-right">
	<!--即时新闻-->
	<div class="main-text-box">
		<div class="main-text-box-tbg">
			<div class="main-text-box-bbg">
				<form name ="searchForm" id="searchForm" action="newsDetailList.jsp" method="post">
					<div>
						新闻分类：
						<select name="categoryId">
							<option value="0">全部</option>
							<option value='1' >国内</option>
							<option value='2' >国际</option>
							<option value='3' >娱乐</option>
							<option value='4' >军事</option>
							<option value='5' >财经</option>
							<option value='6' >天气</option>
						</select>
						新闻标题<input type="text" name="title" id="title" value=''/>
						<button type="submit" class="page-btn">GO</button>
						<button type="button" onclick="addNews();" class="page-btn">增加</button>
						<input type="hidden" name="pageIndex" value="1"/>
					</div>
				</form>
				<table cellpadding="1" cellspacing="1" class="admin-list">
					<thead >
					<tr class="admin-list-head">
						<th>新闻标题</th>
						<th>作者</th>
						<th>时间</th>
						<th>操作</th>
					</tr>
					</thead>
					<tbody>
					<%
						//页面容量：每页显示几条新闻
						int pageSize = 3;
						//当前页码
						String currentPage = request.getParameter("pageIndex");
						if(currentPage == null || currentPage.equals("")){
							currentPage = "1";
						}
						int pageIndex = Integer.parseInt(currentPage);
						//获取分页数据
						//获取查询数据的总条数
						int totalCount = newsService.getTotalCount();
						PageUtil pageUtil = new PageUtil();
						pageUtil.setCurrentPage(pageIndex);
						pageUtil.setPageSize(pageSize);
						pageUtil.setTotalCount(totalCount);
						//总页数
						int totalPage = pageUtil.getTotalPageCount();
						//控制首页和尾页按钮
						if(pageIndex<1){
							pageIndex = 1;
						}else if(pageIndex>totalPage){
							pageIndex = totalPage;
						}
						List<NewsDetails> list = newsService.getPageNewsList(pageIndex,pageSize);
						request.setAttribute("list",list);
						request.setAttribute("news22",new NewsDetails());
					%>
					<%--<c:set var = "news2" value="${2222}"></c:set>--%>
					<%--<c:set target="${news22}" property="title" value="测试"></c:set>--%>
					<%--<c:out value="${news22.title}"></c:out>--%>

					<%--JSTL标签与EL表达式结合  item是要遍历的对象，var是遍历里面的每一个对象 varStatus是循环变量--%>
					<c:forEach items="${list}" var="news" varStatus="status">
						<tr <c:if test="${status.count % 2 == 0}">class="admin-list-td-h2"</c:if> >
							<td><a href="newsDetailView.jsp?id=${news.id}"><c:out value="${news.title}" escapeXml="true"></c:out> </a></td>
							<td><c:out value="${news.author}" default="暂无" ></c:out></td>
							<td><fmt:formatDate value="${news.createDate}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
							<td>
								<a>修改</a>
								<a href="javascript:if(confirm('确认是否删除此新闻？')) location='adminNewsDel.jsp?id=${news.id}'">删除</a>
							</td>
						</tr>
					</c:forEach>
					<input type="hidden" id="totalPage" value="<%=totalPage%>"/>
					</tbody>
				</table>
				<%--分页条原来的位置--%>
				<%--下面的import标签为分页条需要用到的变量，在这里写可以传给rollPage.jsp--%>
				<c:import url="rollPage.jsp">
					<c:param name="totalCount" value="<%=Integer.toString(totalCount)%>">
					</c:param>
					<c:param name="pageIndex" value="<%=Integer.toString(pageIndex)%>">
					</c:param>
					<c:param name="totalPage" value="<%=Integer.toString(totalPage)%>">
					</c:param>
				</c:import>

			</div>
		</div>
	</div>
</div>
</body>
</html>