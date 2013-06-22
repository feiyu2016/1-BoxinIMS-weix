<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>图文富内容回复管理</title>
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
		<li><a href="${ctx}/wechat/newsReply/">图文富内容回复列表</a></li>
		<li class="active"><a href="${ctx}/wechat/newsReply/form?id=${newsReply.id}">图文富内容回复<shiro:hasPermission name="wechat:newsReply:edit">${not empty newsReply.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="wechat:newsReply:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="newsReply" action="${ctx}/wechat/newsReply/save" method="post" class="form-horizontal"  enctype="multipart/form-data">
		<form:hidden path="id"/>
		<form:hidden path="wechatConfig.id"/>
		<form:hidden path="wechatConfig.weChat.id"/>
		<tags:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">问题:</label>
			<div class="controls">
				<form:input path="wechatConfig.upContent" htmlEscape="false" maxlength="11" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">标题:</label>
			<div class="controls">
				<form:input path="title" htmlEscape="false" maxlength="50" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">描述:</label>
			<div class="controls">
				<form:textarea path="description" htmlEscape="false" cols="10" rows="6" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">上传图片:</label>
			<div class="controls">
				<input type="file" name="file" htmlEscape="false" maxlength="50" class="required"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="wechat:newsReply:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
