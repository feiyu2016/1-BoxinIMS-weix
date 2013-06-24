<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>图文富内容回复管理</title>
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
		<li class="active"><a href="${ctx}/wechat/newsReply/">图文富内容回复列表</a></li>
		<shiro:hasPermission name="wechat:newsReply:edit"><li><a href="${ctx}/wechat/newsReply/form">图文富内容回复添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="newsReply" action="${ctx}/wechat/newsReply/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>标题：</label><form:input path="title" htmlEscape="false" maxlength="50" class="input-medium"/>
		&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered ">
		<thead><tr><th>标题</th><th>描述</th><shiro:hasPermission name="wechat:newsReply:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="newsReply">
			<tr>
				<td><a href="${ctx}/wechat/newsReply/form?id=${newsReply.id}">${newsReply.title}</a></td>
				<td>${newsReply.remarks}</td>
				<shiro:hasPermission name="wechat:newsReply:edit"><td>
    				<a href="${ctx}/wechat/newsReply/form?id=${newsReply.id}">修改</a>
					<a href="${ctx}/wechat/newsReply/delete?id=${newsReply.id}" onclick="return confirmx('确认要删除该图文富内容回复吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
