<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>优惠券管理</title>
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
		<li class="active"><a href="${ctx}/mom/coupon/">优惠券列表</a></li>
		<shiro:hasPermission name="momarketing:coupon:edit"><li><a href="${ctx}/mom/coupon/form">优惠券添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="coupon" action="${ctx}/mom/coupon/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>名称 ：</label><form:input path="name" htmlEscape="false" maxlength="50" class="input-medium"/>
		<label>手机号 ：</label><form:input path="mobile" htmlEscape="false" maxlength="50" class="input-medium"/>
		<label>券号码 ：</label><form:input path="number" htmlEscape="false" maxlength="50" class="input-medium"/>
		&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered ">
		<thead><tr><th>名称</th><th>优惠券号</th><th>手机号</th><th>发送方式</th><th>生成时间</th><shiro:hasPermission name="momarketing:coupon:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="coupon">
			<tr>
				<td><a href="${ctx}/mom/coupon/form?id=${coupon.id}">${coupon.name}</a></td>
				<td>${coupon.number}</td>
				<td>${coupon.mobile}</td>
				<td>${coupon.sendType}</td>
				<td>${coupon.createDate}</td>
				<shiro:hasPermission name="momarketing:coupon:edit"><td>
					<a href="${ctx}/mom/coupon/delete?id=${coupon.id}" onclick="return confirmx('确认要删除该优惠券吗？', this.href)">删除</a>
					<a href="${ctx}/mom/coupon/cancel?id=${coupon.id}" onclick="return confirmx('确认要核销该优惠券吗？', this.href)">核销</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
