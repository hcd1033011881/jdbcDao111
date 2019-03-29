<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/3/28
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../common/common.jsp"%>

<%--JSTL标签库引入语句--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <script>
        function page_nav(frm, num) {
            frm.pageIndex.value = num;
            frm.submit();
        }
        //提交GO跳转，跳转前要对数字进行有效性验证，如果数字输入正确，才执行page_nav()函数
        function jump_to(frm, num) {
            var regExp =/^[1-9]\d*$/;
            //拿到隐藏域中提交过来的总页数
            var totalPage = document.getElementById("totalPage").value;
            if(!regExp.test(num)){
                alert("请输入非0的整数数字！");
                // return false;
            }else if((num-totalPage)>0){
                alert("请输入小于或等于"+totalPage+"页的数字！");
                // return false;
            }else{
                page_nav(frm,num)
            }
        }
    </script>

    <%--分页条的页面，所有使用分页的页面都可以使用--%>
    <div class="page-bar">
        <ul class="page-num-ul clearfix">
            <li>共${param.totalCount}条记录&nbsp;&nbsp; ${param.pageIndex}/${param.totalPage}页</li>&nbsp;&nbsp;&nbsp;&nbsp;
            <%--采用form表单提交的方式传值--%>
            <c:if test="${param.pageIndex > 1}">
                <a href="javaScript:page_nav(document.forms[0],1)">首页</a>&nbsp;
                <a href="javaScript:page_nav(document.forms[0],${param.pageIndex - 1})">上一页</a>&nbsp;
            </c:if>

            <c:if test="${param.pageIndex < param.totalPage}">
                <a href="javaScript:page_nav(document.forms[0],${param.pageIndex + 1})">下一页</a>&nbsp;
                <a href="javaScript:page_nav(document.forms[0],${param.totalPage})">最后一页</a>&nbsp;
            </c:if>
        </ul>
        <span class="page-go-form"><label>跳转至</label>
            <input type="text" name="inputPage" id="inputPage" class="page-key" />页
            <button type="button" class="page-btn" onClick='jump_to(document.forms[0],document.getElementById("inputPage").value)'>GO</button>
        </span>
    </div>
</body>
</html>
