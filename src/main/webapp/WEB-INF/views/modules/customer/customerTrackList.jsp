<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>客户跟踪管理</title>
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
		<li class="active"><a href="${ctx}/customer/ct?cid=${customer.id}">客户跟踪列表</a></li>
		<shiro:hasPermission name="customer:customerTrack:edit"><li><a href="${ctx}/customer/ct/form?customer.id=${customer.id}">客户跟踪添加</a></li></shiro:hasPermission>
	</ul>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered ">
		<thead><tr><th>名称</th><th>会谈内容</th><th>会谈时间</th><th>发表时间</th><th>备注</th><shiro:hasPermission name="customer:customerTrack:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="customerTrack">
			<tr>
				<td><a href="${ctx}/customer/ct/form?id=${customerTrack.id}">${customerTrack.customer.name}</a></td>
				<td>${customerTrack.content}</td>
				<td><fmt:formatDate value="${customerTrack.meetTime}" type="both"/>  </td>
				<td><fmt:formatDate value="${customerTrack.createTime}" type="both"/>  </td>
				<td>${customerTrack.remarks}</td>
				<shiro:hasPermission name="customer:customerTrack:edit"><td>
    				<a href="${ctx}/customer/ct/form?id=${customerTrack.id}">修改</a>
    				<a href="${ctx}/customer/ct/form?customer.id=${customerTrack.customer.id}">添加跟踪</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
