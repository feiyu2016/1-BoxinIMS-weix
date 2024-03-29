<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>公司活动管理</title>
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
		<li><a href="${ctx}/ecard/organInfo/">公司活动列表</a></li>
		<li class="active"><a href="${ctx}/ecard/organInfo/form?id=${organInfo.id}">公司活动<shiro:hasPermission name="ecard:organInfo:edit">${not empty organInfo.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="ecard:organInfo:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="organInfo" action="${ctx}/ecard/organInfo/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<form:hidden path="user.id"/>
		<tags:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">单位名称:</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="11" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">简称:</label>
			<div class="controls">
				<form:input path="shortName" htmlEscape="false" maxlength="11" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">电话:</label>
			<div class="controls">
				<form:input path="tel" htmlEscape="false" maxlength="11" class="required"/>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">地址:</label>
			<div class="controls">
				<form:input path="address" htmlEscape="false" maxlength="100"  />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">微博:</label>
			<div class="controls">
				<form:input path="weibo" htmlEscape="false" maxlength="100"  />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">微博:</label>
			<div class="controls">
				<form:input path="weixin" htmlEscape="false" maxlength="100"  />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">网址:</label>
			<div class="controls">
				<form:input path="site" htmlEscape="false" maxlength="50"   />
			</div>
		</div>
		
		
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<form:input path="remarks" htmlEscape="false" maxlength="50" class="required"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="ecard:organInfo:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
