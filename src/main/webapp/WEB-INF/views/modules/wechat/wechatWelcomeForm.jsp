<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>欢迎词管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			changeType('${wechatWelcome.type}');
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
		
		function changeType(v){
			if('text' === v){
				$('#musicContent').hide();
				$('#pureTextContent').show();
			}else if('music' === v){
				$('#pureTextContent').hide();
				$('#musicContent').show();
			}else if('news' === v){
				$('#musicContent').show();
				$('#pureTextContent').hide();
			}else{
				$('#musicContent').hide();
				$('#pureTextContent').show();
			}
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/wechat/welcome/form?id=${wechatWelcome.id}">欢迎词<shiro:hasPermission name="wechat:wechatWelcome:edit">${not empty wechatWelcome.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="wechat:wechatWelcome:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="wechatWelcome" action="${ctx}/wechat/welcome/save" method="post" class="form-horizontal" enctype="multipart/form-data">
		<form:hidden path="id"/>
		<tags:message content="${message}"/>
		<div class="control-group">
			<div class="control-group">
				<label class="control-label">类型:</label>
				<div class="controls">
  					<form:radiobutton   path="type" id="reaio" value="text"  checked="checked" onclick="changeType(this.value)"/> 文字
  					<form:radiobutton   path="type" id="reaio" value="music"  onclick="changeType(this.value)"/> 声音
  					<form:radiobutton   path="type" id="reaio" value="news"  onclick="changeType(this.value)"/> 图文
				</div>
				
			</div>
			<div id="pureTextContent" class="control-group">
				<label class="control-label">内容:</label>
				<div class="controls" id="">
					<form:textarea path="content" htmlEscape="false"  cols="6" rows="5" class="required"/>
				</div>
			</div>
			<div id="musicContent" class="control-group">
				<label class="control-label">标题:</label>
				<div   class="controls" >
					<form:input path="title" htmlEscape="false"  class="required"/>
				</div>
				
				<label class="control-label">描述:</label>
				<div   class="controls" style="margin-top:5px;margin-buttom:5px;">
					<form:textarea path="description" htmlEscape="false"  cols="6" rows="5" class="required"/>
				</div>
				<label class="control-label">上传文件:</label>
				<div class="controls" id="uploadfile">
					<input type="file"  name="file"/>
				</div>
				
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="wechat:wechatWelcome:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
