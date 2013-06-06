<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>关于我们管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/mom/aboutUs/">关于我们列表</a></li>
		<shiro:hasPermission name="momarketing:aboutUs:edit"><li><a href="${ctx}/mom/aboutUs/form">关于我们添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="aboutUs" action="${ctx}/momarketing/aboutUs/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>名称 ：</label><form:input path="name" htmlEscape="false" maxlength="50" class="input-medium"/>
		&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered ">
		<thead><tr><th>名称</th><th>备注</th><shiro:hasPermission name="momarketing:aboutUs:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="aboutUs">
			<tr>
				<td><a href="${ctx}/momarketing/aboutUs/form?id=${aboutUs.id}">${aboutUs.name}</a></td>
				<td>${aboutUs.remarks}</td>
				<shiro:hasPermission name="momarketing:aboutUs:edit"><td>
    				<a href="${ctx}/momarketing/aboutUs/form?id=${aboutUs.id}">修改</a>
					<a href="${ctx}/momarketing/aboutUs/delete?id=${aboutUs.id}" onclick="return confirmx('确认要删除该关于我们吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
