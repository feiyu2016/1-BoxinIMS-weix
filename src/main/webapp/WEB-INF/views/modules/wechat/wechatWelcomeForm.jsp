<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>欢迎词管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			changeType('${wechatWelcome.type}');
			cleanValue();
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
				$('#newsReplyData').hide();
				$('#pureTextContent').show();
			}else if('music' === v){
				$('#pureTextContent').hide();
				$('#musicContent').show();
				$('#newsReplyData').hide();
			}else if('news' === v){
				$('#musicContent').show();
				$('#newsReplyData').show();
				$('#pureTextContent').hide();
			}else{
				$('#newsReplyData').hide();
				$('#musicContent').hide();
				$('#pureTextContent').show();
			}
		}
		
		
		function cleanValue(){
			$('#pic_desc').val('');
			$('#pic_title').val('');
			$('#pic_url').val('');
		}
		
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/wechat/welcome/form?id=${wechatWelcome.id}">欢迎消息</a></li>
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
				<label class="control-label">回复内容:</label>
				<div class="controls" id="">
					<form:textarea path="content" htmlEscape="false"  cols="6" rows="5"  />
				</div>
			</div>
			<div id="musicContent" class="control-group">
				<label class="control-label">图片标题:</label>
				<div   class="controls" >
					<form:input path="title" htmlEscape="false" id="pic_title"  class="required"/>
				</div>
				
				<label class="control-label">链接地址:</label>
				<div   class="controls" style="margin-top:5px;margin-buttom:5px;">
					<form:input path="url" htmlEscape="false"  class="required"  id="pic_url"/>  &nbsp; <span class="alert">必须以 http://开头.</span>
				</div>
				<label class="control-label">图片描述:</label>
				<div   class="controls" style="margin-top:5px;margin-buttom:5px;">
					<form:textarea id="pic_desc" path="description" htmlEscape="false"  cols="6" rows="5" class="required"/>
					
				</div>
				<label class="control-label">上传文件:</label>
				<div class="controls" id="uploadfile">
					<input type="file"  name="file"/> <span class="alert">大图片建议尺寸：720像素 * 400像素;  &nbsp; 小图片建议尺寸：400像素 * 400像素</span>    
				</div>
				
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="wechat:wechatWelcome:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
	
	<div id="newsReplyData"  style="display:none">
	<table id="contentTable" class="table table-striped table-bordered ">
		<thead><th>图片标题</th><th>描述</th><th>原文链接</th><shiro:hasPermission name="wechat:newsReply:edit"><th>操作</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${newsReplyList}" var="newsReply">
			<tr>
				<td>${newsReply.title}</td>
				<td>${newsReply.description}</td>
				<td><a href="${newsReply.url}" target="_blank">${newsReply.url}</a> </td>
				<shiro:hasPermission name="wechat:newsReply:edit"><td>
					<a href="${ctx}/wechat/newsReply/delete?id=${newsReply.id}" onclick="return confirmx('确认要删除该图文富内容回复吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>
