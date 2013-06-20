<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>微信公众平台用户管理</title>
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
		<li><a href="${ctx}/wechat/weChat/">微信公众平台用户列表</a></li>
		<li class="active"><a href="${ctx}/wechat/weChat/form?id=${weChat.id}">微信公众平台用户<shiro:hasPermission name="wechat:weChat:edit">${not empty weChat.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="wechat:weChat:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="weChat" action="${ctx}/wechat/weChat/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<form:hidden path="user.id"/>
		<tags:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">Token:</label>
			<div class="controls">
				<form:input path="token" htmlEscape="false" maxlength="11" class="required"/>&nbsp;<span class="label label-warning">此Token与微信公众平台的Token必须一致</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<form:input path="remarks" htmlEscape="false" maxlength="50" class="required"/>
			</div>
		</div>
		<div class="hero-unit">
	  		<h5>绑定的地址:</h5>
	  		<c:if test="${weChat.id == null} ">
	  			<p>未生成绑定地址。</p>
	  		</c:if>
	  		<c:if test="${weChat.id != null}">
		  		<p>http://www.hdzhx.com/zxims/f/mobsite/wp?wid=${weChat.id }  <span class="label label-warning">将此地址填写至微信公众平台的URL处.</span></p>
	  		</c:if>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="wechat:weChat:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
	
</body>
</html>
