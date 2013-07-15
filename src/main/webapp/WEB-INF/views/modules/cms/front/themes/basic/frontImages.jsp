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
	jQuery(document).ready(function() {
		jQuery("a.example6").fancybox({
			'titlePosition'		: 'outside',
			'overlayColor'		: '#000',
			'overlayOpacity'	: 0.9
		});
	});
	</script>
</head>
<body>
<!--  Content wide start -->
<section class="content">

<div class="demo">
<ul id="list" class="image-grid">


<!-- -------Start------------ -->


<c:forEach items="${page.list}" var="article">

	<li data-id="id-${article.id }" class="buisness">
        <div class="portfolio_content">
        	<span class="pf_img_br"></span>
              <img src="${article.thumb }" alt="img" style="width:212px;height:145px"/>          
            <h4><a href="${article.thumb }">${article.title }</a></h4>
            <p>${article.keywords }</p>
            <div class="link_btn">
                <a href="${article.thumb }"  class="zoom example6"></a>
                <a href="${ctx}/view-${article.category.id}-${article.id}${urlSuffix}" class="link_post"></a>
                <div class="overlay"></div>
            </div>
        </div>
    </li>


</c:forEach>


<!-- -------End ----------- -->

</ul>
</div>

</section>
<!--  Content wide end -->

</body>
</html>
