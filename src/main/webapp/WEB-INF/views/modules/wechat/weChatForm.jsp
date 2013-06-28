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
		<li class="active"><a href="${ctx}/wechat/weChat/form?id=${weChat.id}">绑定微信<shiro:hasPermission name="wechat:weChat:edit">${not empty weChat.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="wechat:weChat:edit">查看</shiro:lacksPermission></a></li>
		<shiro:hasPermission name="sys:menu:edit"><li><a href="${ctx}/wechat/weChat/">Token列表</a></li>	</shiro:hasPermission>
		<li><a href="${ctx}/wechat/welcome/form">欢迎消息</a></li>
		<li><a href="${ctx}/wechat/config/form">文字回复</a></li>
		<li><a href="${ctx}/wechat/newsReply/form">图文回复</a></li>
		<li><a href="${ctx}/wechat/config/form?type=music">语音回复</a></li>
		<li><a href="${ctx}/wechat/newsReply/">回复列表</a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="weChat" action="${ctx}/wechat/weChat/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<form:hidden path="user.id"/>
		<tags:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">Token:</label>
			<div class="controls">
				<form:input path="token" htmlEscape="false" maxlength="50" class="required"/>&nbsp;<span class="alert">此Token对应微信公众平台的Token</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">默认回复内容:</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false"  cols="6" rows="10"  />  <span class="alert">用户输入内容无法找到预先设置好的内容时，刚回复此默认回复内容。</span> 
				
			</div>
		</div>
		
		<div class="alert alert-block alert-error fade in">
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
	
	<div class="control-group">
			<label class="control-label">示例图:</label>
			<div class="controls">
				<img alt="微信绑定"  height="80%" width="80%" src="${ctxStatic }/images/weixintoken.png"> 
				
			</div>
		</div>
	
</body>
</html>
