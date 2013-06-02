<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<html>
<head>
	<title>移动营销项目管理</title>
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
		<li class="active"><a href="${ctx}/mom/project/list">移动营销项目列表</a></li>
		<shiro:hasPermission name="momarketing:project:edit"><li><a href="${ctx}/mom/project/form">移动营销项目添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="project" action="${ctx}/momarketing/project/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>名称 ：</label><form:input path="name" htmlEscape="false" maxlength="50" class="input-medium"/>
		&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered ">
		<thead><tr><th>名称</th><th>模板</th><th>备注</th><shiro:hasPermission name="momarketing:project:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="project">
			<tr>
				<td><a href="${root}/f/vpc/vp/${project.qrCode.id}.html">${project.name}</a></td>
				<td>${project.pageTemplate.name}</td>
				<td>${project.remarks}</td>
				<shiro:hasPermission name="momarketing:project:edit"><td>
    				<a href="${ctx}/mom/project/form?id=${project.id}">修改</a>
    				<a href="${ctx}/momarketing/project/form?id=${project.id}">渠道</a>
					<a href="${ctx}/momarketing/project/delete?id=${project.id}" onclick="return confirmx('确认要删除该移动营销项目吗？', this.href)">暂停</a>
    				<a href="${ctx}/momarketing/project/form?id=${project.id}">统计分析</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
