<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/head.jsp"%>

<html>
<head>
<title>移动营销项目管理</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="decorator" content="default" />

<meta name="description" content="Bianca Mobile Template">
<meta name="viewport"
	content="width=device-width initial-scale=1.0  maximum-scale=1.0">
<meta name="author" content="ariella - WrapBootstrap">

<link href="${ctxStatic}/jquery-mobile/css/jquery.mobile-1.3.1.min.css" type="text/css" rel="stylesheet" />
<link href="${ctxStatic}/jquery-mobile/css/jquery.mobile.theme-1.3.1.min.css" type="text/css" rel="stylesheet" />

<script src="${ctxStatic}/jquery-mobile/jquery.mobile-1.3.1.js" type="text/javascript"></script>
<script src="${ctxStatic}/jquery-mobile/jquery.mobile-1.3.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
	function goUrl(url){
		location.href=url;
	}
</script>



</head>
<body>
		
<div data-url="demo-page" data-role="page" id="demo-page" data-theme="d">
	

    <div data-role="header" data-theme="c">
        <h1>${project.companyName }->${menuName }</h1>
        <a href="#left-panel" data-icon="bars" data-shadow="false" data-iconshadow="true" >导航栏</a>
    </div><!-- /header -->
    <div data-role="content">
        <div class="article">
            <div class="alert alert-error">
				${ errorInfo}
			</div>
            <p>A fixed-gear or fixed-wheel bicycle, commonly known as a fixie, is a bicycle that has a drivetrain wi.</p>
        </div><!-- /article -->
    </div><!-- /content -->
    <div data-role="panel" id="left-panel" data-theme="c">
        <ul data-role="listview" data-theme="d">
            <li data-icon="delete"><a href="#" data-rel="close">Close</a></li>
            <c:forEach items="${menus}" var="menu">
				<li data-icon="go"><a href="#" onclick="goUrl('${root }/${menu.url}/${project.id}.html?menuId=${menu.id}')">${menu.name}</a></li>
			</c:forEach>
        </ul>
    </div><!-- /panel -->
</div>

</body>
</html>
