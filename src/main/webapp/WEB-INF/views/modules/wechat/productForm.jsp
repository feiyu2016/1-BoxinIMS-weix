<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>产品管理</title>
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
		<li><a href="${ctx}/wechat/product/">产品列表</a></li>
		<li class="active"><a href="${ctx}/wechat/product/form?id=${product.id}">产品<shiro:hasPermission name="wechat:product:edit">${not empty product.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="wechat:product:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="product" action="${ctx}/wechat/product/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<form:hidden path="user.id"/>
		<tags:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">名称:</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="11" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">价格:</label>
			<div class="controls">
				<form:input path="price" htmlEscape="false" maxlength="150"  />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">原价格:</label>
			<div class="controls">
				<form:input path="sourcePrice" htmlEscape="false" maxlength="150"  />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">产品数量:</label>
			<div class="controls">
				<form:input path="amount" htmlEscape="false" maxlength="150"  />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">发布:</label>
			<div class="controls">
				<form:radiobutton path="isSale"/> 发布       <form:radiobutton path="isSale"/> 不发布  
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">简介:</label>
			<div class="controls">
				<form:textarea path="description" htmlEscape="false"  cols="6" rows="8" />
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">产品图片1:</label>
			<div class="controls">
				<input type="file"	name="productPic1"/>			
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">产品图片2:</label>
			<div class="controls">
				<input type="file"	name="productPic2"/>			
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">产品图片3:</label>
			<div class="controls">
				<input type="file"	name="productPic3"/>			
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">展示图片:</label>
			<div class="controls">
				<input type="file"	name="productPic"/>	<span class="alert">推荐尺寸294*145</span>		
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="wechat:product:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
