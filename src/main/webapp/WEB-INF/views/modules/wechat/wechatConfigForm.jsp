<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>自动回复</title>
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
		<li><a href="${ctx}/wechat/config/">回复列表</a></li>
		<li><a href="${ctx}/wechat/newsReply/form?cfid=${wechatConfig.id}&wid=${weChat.id}">图文回复</a></li>
		<li class="active"><a href="${ctx}/wechat/wechat/form?id=${wechatConfig.id}">文字回复</a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="wechatConfig" action="${ctx}/wechat/config/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<form:hidden path="weChat.id"/>
		<tags:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">关键词：</label>
			<div class="controls">
				<form:input path="upContent" htmlEscape="false" maxlength="11" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">回复内容:</label>
			<div class="controls">
				<form:textarea path="downContent" htmlEscape="false"  cols="20" rows="6" class="required"/>
			</div>
		</div>
		
		<div class="form-actions">
			<shiro:hasPermission name="wechat:wechatConfig:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
