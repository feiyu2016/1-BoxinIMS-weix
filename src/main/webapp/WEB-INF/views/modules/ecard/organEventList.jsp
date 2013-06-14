<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>公司活动管理</title>
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
		<li class="active"><a href="${ctx}/ecard/organEvent/">公司活动列表</a></li>
		<shiro:hasPermission name="ecard:organEvent:edit"><li><a href="${ctx}/ecard/organEvent/form">公司活动添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="organEvent" action="${ctx}/ecard/organEvent/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>主题：</label><form:input path="title" htmlEscape="false" maxlength="50" class="input-medium"/>
		&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered ">
		<thead><tr><th>名称</th><th>活动内容</th><th>备注</th><shiro:hasPermission name="ecard:organEvent:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="organEvent">
			<tr>
				<td><a href="${ctx}/ecard/organEvent/form?id=${organEvent.id}">${organEvent.title}</a></td>
				<td>${organEvent.content}</td>
				<td>${organEvent.remarks}</td>
				<shiro:hasPermission name="ecard:organEvent:edit"><td>
    				<a href="${ctx}/ecard/organEvent/form?id=${organEvent.id}">修改</a>
					<a href="${ctx}/ecard/organEvent/delete?id=${organEvent.id}" onclick="return confirmx('确认要删除该公司活动吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
