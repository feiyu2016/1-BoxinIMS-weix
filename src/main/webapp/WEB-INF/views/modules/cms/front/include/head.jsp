<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta name="author" content="http://thinkgem.iteye.com"/>
<meta http-equiv="X-UA-Compatible" content="IE=7,IE=9,IE=10" />
<script src="${ctxStatic}/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="${ctxStatic}/jquery/jquery-migrate-1.1.1.min.js" type="text/javascript"></script>
<c:if test="${site.theme eq 'basic'}">
	<link href="${ctxStatic}/bootstrap/2.3.1/css_${cookie.theme.value eq 'cerulean'?'cerulean':'united'}/bootstrap.min.css" type="text/css" rel="stylesheet" />
	<script src="${ctxStatic}/bootstrap/2.3.1/js/bootstrap.min.js" type="text/javascript"></script>
	<!--[if lte IE 6]><link href="${ctxStatic}/bootstrap/bsie/css/bootstrap-ie6.min.css" type="text/css" rel="stylesheet" />
	<script src="${ctxStatic}/bootstrap/bsie/js/bootstrap-ie.min.js" type="text/javascript"></script><![endif]-->
	<link href="${ctxStatic}/common/jeesite.min.css" type="text/css" rel="stylesheet" />
</c:if>
<link href="${ctxStaticFront}/themes/${site.theme}/style.min.css" type="text/css" rel="stylesheet" />
<script src="${ctxStaticFront}/themes/${site.theme}/script.min.js" type="text/javascript"></script>


<!-- My Site Css -->


<link href="${ctxStatic}/mysite/css/reset.css" rel="stylesheet" type="text/css" />
<link href="${ctxStatic}/mysite/css/layout.css" rel="stylesheet" type="text/css" />
<link href="${ctxStatic}/mysite/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctxStatic}/mysite/css/jqueryslidemenu.css" rel="stylesheet" type="text/css" />
<link href="${ctxStatic}/mysite/css/elastic_slider.css" rel="stylesheet" type="text/css"/>
<link href="${ctxStatic}/mysite/css/widgets.css" rel="stylesheet" type="text/css"/>
<link href="${ctxStatic}/mysite/css/portfolio.css" rel="stylesheet" type="text/css"/>
<link href="${ctxStatic}/mysite/css/quicksand.css" rel="stylesheet" type="text/css"/>
<link href="${ctxStatic}/mysite/css/skin.css" rel="stylesheet" type="text/css"/>
<link href="${ctxStatic}/mysite/css/font-awesome.css" rel="stylesheet" type="text/css"/>
<link href="${ctxStatic}/mysite/css/responsive.css" rel="stylesheet" type="text/css"  /> 
<link href="${ctxStatic}/mysite/js/fancybox/jquery.fancybox-1.3.4.css" rel="stylesheet" type="text/css" media="screen" /> 


<script src="${ctxStaticFront}/themes/${site.theme}/script.min.js" type="text/javascript"></script>


<script type="text/javascript" src="${ctxStatic}/mysite/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="${ctxStatic}/mysite/js/html5.js"></script>
<script type="text/javascript" src="${ctxStatic}/mysite/js/jqueryslidemenu.js"></script>
<script type="text/javascript" src="${ctxStatic}/mysite/js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="${ctxStatic}/mysite/js/jquery.eislideshow.js"></script>
<script type="text/javascript" src="${ctxStatic}/mysite/js/custom.js"></script>
<script type="text/javascript" src="${ctxStatic}/mysite/js/quicksand.js"></script>
<script type="text/javascript" src="${ctxStatic}/mysite/js/fancybox/jquery.fancybox-1.3.4.js"></script>

<script type="text/javascript">
	// Elastic Slider
	$(function() {
		$('#ei-slider').eislideshow({
			easing		: 'easeOutExpo',
			titleeasing	: 'easeOutExpo',
			titlespeed	: 1200
		});
	});// 
</script>


