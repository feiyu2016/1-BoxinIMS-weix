<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/modules/cms/front/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/modules/cms/front/include/head.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>${category.name}</title>
	<meta name="decorator" content="cms_default_${site.theme}"/>
	<meta name="description" content="${category.desciption}" />
	<meta name="keywords" content="${category.keywords}" />
	
	<script type="text/javascript">
		$(window).load(function() {
			$('.flexslider').flexslider();
		});
		
		
		
	</script>
</head>
<body>


<!--  Content wide start -->
<section class="content">

<h3>${article.title }</h3>

<div class="one_third">
<div class="flexslider">
    <ul class="slides">
        <li><img src="${article.thumb }" alt="img" /></li>
     </ul>
</div>
</div>
<div class="two_third_last">
	<div class="portfolio_single">
        <ul>
            <li><strong>简介:</strong>${article.desciption }</li>
        </ul>
    </div>
</div>
<p>${article.articleData.content }</p><br />
</section>
<!--  Content wide end -->

</body>
</html>
