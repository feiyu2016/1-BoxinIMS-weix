<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>微信上下行数据交互管理</title>
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
		<li class="active"><a href="${ctx}/wechat/config/">回复交互列表</a></li>
		<shiro:hasPermission name="wechat:wechatConfig:edit"><li><a href="${ctx}/wechat/config/form">自动回复交互添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="wechatConfig" action="${ctx}/wechat/config/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>问题 ：</label><form:input path="upContent" htmlEscape="false" maxlength="50" class="input-medium"/>
		&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered ">
		<thead><tr><th>问题</th><th>回复</th><shiro:hasPermission name="wechat:wechatConfig:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="wechatConfig">
			<tr>
				<td><a href="${ctx}/wechat/config/form?id=${wechatConfig.id}">${wechatConfig.upContent}</a></td>
				<td>${wechatConfig.downContent}</td>
				<shiro:hasPermission name="wechat:wechatConfig:edit"><td>
    				<a href="${ctx}/wechat/config/form?id=${wechatConfig.id}">修改</a>
					<a href="${ctx}/wechat/config/delete?id=${wechatConfig.id}" onclick="return confirmx('确认要删除该微信上下行数据交互吗？', this.href)">删除</a>
					<a href="${ctx}/wechat/newsReply/form?cfid=${wechatConfig.id}&wid=${wechatConfig.weChat.id}">添加图文回复</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
