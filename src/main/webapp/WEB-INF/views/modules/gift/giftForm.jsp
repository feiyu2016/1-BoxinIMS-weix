<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>礼品管理</title>
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
		
		function setFilePath(path){
			jQuery("#filePath").val(path);
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/gift/gift/">礼品列表</a></li>
		<li class="active"><a href="${ctx}/gift/gift/form?id=${gift.id}">礼品<shiro:hasPermission name="gift:gift:edit">${not empty gift.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="gift:gift:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="gift" action="${ctx}/gift/gift/save" method="post" class="form-horizontal"  enctype="multipart/form-data">
		<form:hidden path="id"/>
		<form:hidden path="user.id"/>
		<form:hidden path="qrCode.id"/>
		<form:hidden path="filePath" id="filePath"/>
		<tags:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">名称:</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="50" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">音频文件:</label>
			<div class="controls">
				<input type="file" name="voiceFile" htmlEscape="false"    onchange="setFilePath(this.value)"/> &nbsp;<span class="alert">请上传Mp3文件，文件大小不得超过5M.</span>
			</div>
		</div>
		
		
		<div class="control-group">
			<label class="control-label">密码:</label>
			<div class="controls">
				<form:input path="password" htmlEscape="false" maxlength="50" />  <span class="alert">需要保密的语音，请设置密码，不设置默认为不加密.</span> 
			</div>
			
		</div>
		
		
		
		<div class="control-group" style="display:none">
			<label class="control-label">音频文件:</label>
			<div class="controls">
				<input type="file" name="file" htmlEscape="false"    onchange="setFilePath(this.value)"/> &nbsp;<span class="alert">请上传Mp3文件，文件大小不得超过5M.</span>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">简介:</label>
			<div class="controls">
				<form:textarea id="content" htmlEscape="true"  path="content" rows="4" maxlength="200" class="input-xxlarge required"/>
				<tags:ckeditor replace="content" uploadPath="/cms/article" />
			</div>
		</div>
		
		
		
		<div class="form-actions">
			<shiro:hasPermission name="gift:gift:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
