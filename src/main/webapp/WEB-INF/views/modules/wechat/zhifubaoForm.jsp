<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>支付宝帐号信息管理</title>
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
		<li class="active"><a href="${ctx}/wechat/zhifubao/form?id=${zhifubao.id}">支付宝帐号信息<shiro:hasPermission name="wechat:zhifubao:edit">${not empty zhifubao.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="wechat:zhifubao:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="zhifubao" action="${ctx}/wechat/zhifubao/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<form:hidden path="user.id"/>
		<tags:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">用户名:</label> 
			<div class="controls">
				<form:input path="loginName" htmlEscape="false" maxlength="50" class="required"/>  &nbsp;<span class="alert">支付宝的登录名称:如xxxx@163.com </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">用户ID:</label> 
			<div class="controls">
				<form:input path="pid" htmlEscape="false" maxlength="50" class="required"/> &nbsp; <span class="alert">支付宝的PID:如  2088010000000795 </span>  
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">密钥:</label> 
			<div class="controls">
				<form:input path="pkey" htmlEscape="false" maxlength="50" class="required"/> &nbsp;<span class="alert">支付宝的Key:如  ctzora32rx0edfegh6dchbaa4dgufdrw </span>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="wechat:zhifubao:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
