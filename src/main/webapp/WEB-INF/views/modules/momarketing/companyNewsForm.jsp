<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>公司动态管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/momarketing/companyNews/">公司动态列表</a></li>
		<li class="active"><a href="${ctx}/mom/comnews/form?id=${companyNews.id}">公司动态<shiro:hasPermission name="momarketing:companyNews:edit">${not empty companyNews.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="momarketing:companyNews:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="companyNews" action="${ctx}/mom/comnews/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<form:hidden path="project.id"/>
		<form:hidden path="user.id"/>
		<tags:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">标题:</label>
			<div class="controls">
				<form:input path="title" htmlEscape="false" maxlength="11" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">关键字:</label>
			<div class="controls">
				<form:input path="keyWord" htmlEscape="false" maxlength="11" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">新闻内容:</label>
			<div class="controls">
				<form:input path="content" htmlEscape="false" maxlength="11" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<form:input path="remarks" htmlEscape="false" maxlength="50" class="required"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="momarketing:companyNews:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
