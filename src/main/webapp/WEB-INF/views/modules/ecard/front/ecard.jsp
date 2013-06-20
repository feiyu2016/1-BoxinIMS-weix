<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/head.jsp"%>

<html>
<head>
<title>${ecard.name}的电子名片</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="decorator" content="default" />
<meta name="description" content="Bianca Mobile Template">
<meta name="viewport"
	content="width=device-width initial-scale=1.0  maximum-scale=1.0">
<meta name="author" content="ariella - WrapBootstrap">
<link href="${ctxStatic}/jquery-mobile/css/jquery.mobile-1.3.1.min.css" type="text/css" rel="stylesheet" />
<script src="${ctxStatic}/jquery-mobile/jquery.mobile-1.3.1.js" type="text/javascript"></script>
<script type="text/javascript">
	function goUrl(url){
		location.href=url;
	}
</script>



</head>
<body>
		
<div class="container">
 	
 	    <div class="row-fluid">
    <div class="span12" align="center"><h1>${ecard.name }</h1></div>
    <div class="span8" align="center"><label>部门</label>	</div>
    </div>
    
    
    <div id="footer" class="fluid">   公司活动</div>
    	<ul>
    <c:forEach items="${ecard.organInfo.organEvents }" var="event">
    	
    	<li>${event.title }</li>
    </c:forEach>
    	</ul>
</div>

</html>
