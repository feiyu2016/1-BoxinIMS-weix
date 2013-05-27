<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>移动营销项目管理</title>
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
		<li><a href="${ctx}/mom/project/">移动营销项目列表</a></li>
		<li class="active"><a href="${ctx}/momarketing/project/form?id=${project.id}">移动营销项目<shiro:hasPermission name="momarketing:project:edit">${not empty project.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="momarketing:project:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="project" action="${ctx}/mom/project/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<form:hidden path="user.id" />
		<tags:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">名称:</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="11" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">电话:</label>
			<div class="controls">
				<form:input path="mobile" htmlEscape="false" maxlength="11" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">公司地址:</label>
			<div class="controls">
				<form:input path="companyName" htmlEscape="false" maxlength="11" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">简介:</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" maxlength="50" cols="300" rows="5" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">生效时间:</label>
			<div class="controls">
				<form:input path="startDate" htmlEscape="false" maxlength="11" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">失效时间:</label>
			<div class="controls">
				<form:input path="endDate" htmlEscape="false" maxlength="11" class="required"/>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">行业类型:</label>
			<div class="controls">
				<form:select path="industryType">
					<form:option value="" label="请选择"/>
					<form:options items="${fns:getDictList('ims_industry_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">邮箱:</label>
			<div class="controls">
				<form:input path="mail" htmlEscape="false" maxlength="11" class="required"/>
			</div>
		</div>
		
		<div class="form-actions">
			<shiro:hasPermission name="momarketing:project:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
