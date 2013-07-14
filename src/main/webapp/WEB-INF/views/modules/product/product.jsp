<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

    <meta name="decorator" content="default"/>
		<%@include file="/WEB-INF/views/include/dialog.jsp" %>
  </head>

  <body>
    <ul class="nav nav-tabs">
    	<li class="active"><a href="${ctx}/product/formItem">添加产品项</a></li>
    	<li><a href="${ctx}/product/formClassify">添加产品类型</a></li>
    </ul>
  </body>
</html>
