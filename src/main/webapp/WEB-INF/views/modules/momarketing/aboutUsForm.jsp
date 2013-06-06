<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>关于我们管理</title>
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
		<li><a href="${ctx}/mom/aboutUs/">关于我们列表</a></li>
		<li class="active"><a href="${ctx}/momarketing/aboutUs/form?id=${aboutUs.id}">关于我们<shiro:hasPermission name="momarketing:aboutUs:edit">${not empty aboutUs.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="momarketing:aboutUs:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="aboutUs" action="${ctx}/mom/aboutUs/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<form:hidden path="project.id"/>
		<form:hidden path="user.id"/>
		<tags:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">公司名称:</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="11" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">公司固话:</label>
			<div class="controls">
				<form:input path="tel" htmlEscape="false" maxlength="11" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">手机:</label>
			<div class="controls">
				<form:input path="mobile" htmlEscape="false" maxlength="11" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">QQ:</label>
			<div class="controls">
				<form:input path="qq" htmlEscape="false" maxlength="11" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">微信:</label>
			<div class="controls">
				<form:input path="weixin" htmlEscape="false" maxlength="11" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">微博:</label>
			<div class="controls">
				<form:input path="weibo" htmlEscape="false" maxlength="11" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">邮箱:</label>
			<div class="controls">
				<form:input path="mail" htmlEscape="false" maxlength="11" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">简介:</label>
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
			<shiro:hasPermission name="momarketing:aboutUs:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
