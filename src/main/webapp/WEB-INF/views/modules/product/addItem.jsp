<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>

  <body>
     <ul class="nav nav-tabs">
    	<li  class="active"><a href="${ctx}/product/formItem">产品项</a></li>
    	<li> <a href="${ctx}/product/formClassify">产品类型</a></li>
    </ul>
    <form:form id="inputForm" modelAttribute="item" action="${ctx}/product/saveItem" method="post" >
    	<div class="control-group">
    		<label class="control-label">名称:</label>
				<div class="controls">
					<form:input path="name" htmlEscape="false" maxlength="11" class="required"/>
				</div>
    	</div>
    	<div class="control-group">
    		<label class="control-label">短名称:</label>
				<div class="controls">
					<form:input path="shortName" htmlEscape="false" maxlength="11" class="required"/>
				</div>
    	</div>
    	<div class="control-group">
    		<label class="control-label">价格:</label>
				<div class="controls">
					<form:input path="price" htmlEscape="false" maxlength="11" class="required"/>
				</div>
    	</div>
    	<div class="control-group">
    		<label class="control-label">优惠价:</label>
				<div class="controls">
					<form:input path="preferentialPrice" htmlEscape="false" maxlength="11" class="required"/>
				</div>
    	</div>
    	<div class="control-group">
    		<label class="control-label">是否发布:</label>
				<div class="controls">
					<form:radiobutton path="publish" value="true"/>是
					<form:radiobutton path="publish" value="false"/>否
				</div>
    	</div>
    	<div class="form-actions">
			<shiro:hasPermission name="ims:product:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
    </form:form>
    
  </body>
</html>
