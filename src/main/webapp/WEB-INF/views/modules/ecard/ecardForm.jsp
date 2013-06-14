<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
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
		<li><a href="${ctx}/ecard/ecard/">公司活动列表</a></li>
		<li class="active"><a href="${ctx}/ecard/ecard/form?id=${ecard.id}">公司活动<shiro:hasPermission name="ecard:ecard:edit">${not empty ecard.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="ecard:ecard:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="ecard" action="${ctx}/ecard/ecard/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<form:hidden path="user.id"/>
		<form:hidden path="organInfo.id"/>
		
		<tags:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">二维码:</label>
			<div class="controls">
				<img src="${root}/servlet/qrc?qrcodeId=${ecard.qrCode.id}"/><a href="${ecard.qrCode.content }" target="_blank">预览 </a> 
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">姓名:</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="11" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">部门:</label>
			<div class="controls">
				<form:input path="department" htmlEscape="false" maxlength="30" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">职位:</label>
			<div class="controls">
				<form:input path="title" htmlEscape="false" maxlength="11" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">固定电话:</label>
			<div class="controls">
				<form:input path="tel" htmlEscape="false" maxlength="11" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">移动电话:</label>
			<div class="controls">
				<form:input path="mobile" htmlEscape="false" maxlength="20" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">电子邮箱:</label>
			<div class="controls">
				<form:input path="mail" htmlEscape="false" maxlength="50" class="email"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">QQ:</label>
			<div class="controls">
				<form:input path="qq" htmlEscape="false" maxlength="11" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">微信:</label>
			<div class="controls">
				<form:input path="weixin" htmlEscape="false" maxlength="11" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">微博:</label>
			<div class="controls">
				<form:input path="weibo" htmlEscape="false" maxlength="11" />
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">上传照片:</label>
			<div class="controls">
				<form:input path="logo" htmlEscape="false" maxlength="11" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">简介:</label>
			<div class="controls">
				<form:input path="logo" htmlEscape="false" maxlength="11" />
			</div>
		</div>
		
		
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<form:input path="remarks" htmlEscape="false" maxlength="50" />
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="ecard:ecard:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
