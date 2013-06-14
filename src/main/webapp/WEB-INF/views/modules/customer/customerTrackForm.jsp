<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>客户跟踪管理</title>
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
		<li><a href="${ctx}/customer/ct?cid=${customer.id}">客户跟踪列表</a></li>
		<li class="active"><a href="${ctx}/customer/ct/form?id=${customerTrack.id}&customer.id=${customer.id}">客户跟踪<shiro:hasPermission name="customer:customerTrack:edit">${not empty customerTrack.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="customer:customerTrack:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="customerTrack" action="${ctx}/customer/ct/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<form:hidden path="user.id"/>
		<form:hidden path="customer.id"/>
		<tags:message content="${message}"/>
		
		<div class="control-group">
			<label class="control-label">商谈结果:</label>
			<div class="controls">
				<form:textarea id="content" htmlEscape="true"  path="content" rows="4" maxlength="200" class="input-xxlarge"/>
				<tags:ckeditor replace="content" uploadPath="/cms/article" />
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">商谈时间:</label>
			<div class="controls">
				<div class="input-append">
					<script src="${ctxStatic}/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
					<input id="meetTime" name="meetTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
						value="<fmt:formatDate value="${customerTrack.meetTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
						onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
				</div>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<form:input path="remarks" htmlEscape="false" maxlength="50" />
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="customer:customerTrack:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
