<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>支付宝帐号信息管理</title>
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
		<li class="active"><a href="${ctx}/wechat/zhifubao/">支付宝帐号信息列表</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="zhifubao" action="${ctx}/wechat/zhifubao/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>名称 ：</label><form:input path="name" htmlEscape="false" maxlength="50" class="input-medium"/>
		&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered ">
		<thead><tr><th>名称</th><th>帐号ID</th><th>密钥</th><shiro:hasPermission name="wechat:zhifubao:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="zhifubao">
			<tr>
				<td><a href="${ctx}/wechat/zhifubao/form?id=${zhifubao.id}">${zhifubao.loginName}</a></td>
				<td>${zhifubao.pid}</td>
				<td>${zhifubao.pkey}</td>
				<shiro:hasPermission name="wechat:zhifubao:edit"><td>
    				<a href="${ctx}/wechat/zhifubao/form?id=${zhifubao.id}">修改</a>
					<a href="${ctx}/wechat/zhifubao/delete?id=${zhifubao.id}" onclick="return confirmx('确认要删除该支付宝帐号信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
