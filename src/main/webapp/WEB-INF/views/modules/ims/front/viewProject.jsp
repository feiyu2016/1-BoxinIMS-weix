<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<html>
<head>
	<title>移动营销项目管理</title>
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
	<div class="container-fluid">
  <div class="row-fluid">
    <div class="span4 clearfix" >
    	<h3 class="heading">项目信息</h3>
    	<p>
	    	<img src="${root}/servlet/qrc?qrcodeId=${id}"/>预览
    	</p>
    	
    </div>
    <div class="span8">
    	<h3>访问统计 </h3>
    	<table class="table"></table>
    </div>
  </div>
</div> 
	
</body>
</html>
