<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>礼品管理</title>
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
		<li class="active"><a href="${ctx}/gift/gift/">礼品列表</a></li>
		<shiro:hasPermission name="gift:gift:edit"><li><a href="${ctx}/gift/gift/form">礼品添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="gift" action="${ctx}/gift/gift/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>名称 ：</label><form:input path="name" htmlEscape="false" maxlength="50" class="input-medium"/>
		&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered ">
		<thead><tr><th>名称</th><th>开始时间</th><th>结束时间</th><th>播放次数</th><th>简介</th><th>二维码</th><shiro:hasPermission name="gift:gift:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="gift">
			<tr>
				<td><a href="${ctx}/gift/gift/form?id=${gift.id}">${gift.name}</a></td>
				<td>${gift.createDate}</td>
				<td>${gift.endDate}</td>
				<td>${gift.pvCount}</td>
				<td>${gift.content}</td>
				<td><button class="btn btn-success"  data-toggle="modal" data-target="#myModal${gift.id }">查看</button></td>
				<shiro:hasPermission name="gift:gift:edit"><td>
    				<a href="${ctx}/gift/gift/form?id=${gift.id}">修改</a>
					<a href="${ctx}/gift/gift/delete?id=${gift.id}" onclick="return confirmx('确认要删除该礼品吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>


				<div id="myModal${gift.id }" class="modal hide fade" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width:400px;">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h3 id="myModalLabel">二维码</h3>
					</div>
					<div class="modal-body">
						<p>
							<img src="${qrCodeUrl }${gift.qrCode.id}" />
						</p>
					</div>
					<div class="modal-footer">
						<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
					</div>
				</div>
			</c:forEach>
		</tbody>
	</table>
	
	<div class="pagination">${page}</div>
</body>
</html>
