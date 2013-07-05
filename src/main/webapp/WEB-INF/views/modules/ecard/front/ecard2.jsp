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

<link href="${ctxStatic}/ecard/p_blue/css/amazium.css" type="text/css" rel="stylesheet" />
<link href="${ctxStatic}/ecard/p_blue/css/base.css" type="text/css" rel="stylesheet" />

	<link rel="stylesheet" href="${ctxStatic}/ecard/p_blue/css/layout.css" />
    <link rel="stylesheet" href="${ctxStatic}/ecard/p_blue/css/fonts.css" />
    <link rel="stylesheet" href="${ctxStatic}/ecard/p_blue/css/prettyPhoto.css" />


</head>
<body>
		
 	
 	    <div class="row-fluid">
		    <div class="span12" align="center"><h1>${ecard.name }</h1></div>
		    <div class="span8" align="center"><label>部门:</label> ${ecard.department }	</div>
		    <div class="span8" align="center"><label>QQ:</label> ${ecard.qq }	</div>
		    <div class="span8" align="center"><label>电话:</label> ${ecard.mobile }	</div>
    	</div>
    	<img alt="照片" src="${url }">
    
    <div id="footer" class="fluid">   公司活动</div>
    	<ul>
    <c:forEach items="${ecard.organInfo.organEvents }" var="event">
    	
    	<li>${event.title }</li>
    </c:forEach>
    	</ul>

</html>
