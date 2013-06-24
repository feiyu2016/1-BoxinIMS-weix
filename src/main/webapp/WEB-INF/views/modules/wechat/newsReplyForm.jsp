<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>


<html>
<head>
	<title>图文富内容回复管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript" src="${ctxStatic}/bootstrap/2.3.1/docs/assets/js/bootstrap-popover.js"></script>
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
		
		function showTip(id){
			//$('#question_tip').popover('show')
		}
		
		function  setUrl(url){
			$('#url').value(url);
		}
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
				<form:input path="wechatConfig.upContent" htmlEscape="false" onclick="showTip('question')" maxlength="11" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">图片标题:</label>
			<div class="controls">
				<form:input path="title" htmlEscape="false" maxlength="50" onmouseover="showTip('pic_title')" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">图片描述:</label>
			<div class="controls">
				<form:textarea path="description" htmlEscape="false" cols="10" rows="6"   class="required"
					data-toggle="popover" data-placement="right" data-content="Vivamus sagittis lacus vel augue laoreet rutrum faucibus." title="" data-original-title="Popover on right"
				/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">上传图片:</label>
			<div class="controls">
				<input type="file" name="file" htmlEscape="false" maxlength="50" class="required"/>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">链接URL:</label>
			<div class="controls">
				<form:input path="url"  id="url" htmlEscape="false" maxlength="50" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">上传二维码图片:</label>
			<div class="controls">
				<input type="file" name="qrfile" htmlEscape="false" maxlength="50" class="required" onchange="setUrl(this.value)"/>
			</div>
		</div>
		
		<div class="form-actions">
			<shiro:hasPermission name="wechat:newsReply:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>

	<div class="popover fade right in" 
<<<<<<< HEAD
		style="top: 12.5px; left: 242px; display: none;" id="question_tip">
=======
		style="top: 12.5px; left: 242px; display: block;" id="question_tip">
>>>>>>> 994d3d37b372fc388d9bc5987d26f16f207fdab8
		<div class="arrow"></div>
		<h3 class="popover-title">设置问题</h3>
		<div class="popover-content">在此处请输入自动回复设置的问题。</div>
	</div>
	
	
</body>
</html>
