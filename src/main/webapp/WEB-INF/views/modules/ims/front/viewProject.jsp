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
root = ${root }
<body>
	<div class="container-fluid">
  <div class="row-fluid">
    <div class="span2">
       <iframe src="${root}/servlet/qrc?qrcodeId=${id}"  style   = "overflow-x:hidden;border:0"   width="400px"   height="400px" />
    </div>
    <div class="span10">
       
    </div>
  </div>
</div>
	
</body>
</html>
