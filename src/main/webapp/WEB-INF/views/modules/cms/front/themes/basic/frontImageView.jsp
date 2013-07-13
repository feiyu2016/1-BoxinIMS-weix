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
<div id="background_bg_inner"></div>


<!--  Content wide start -->
<section class="content">

<section class="sub_header">
    <h2>Portfolio Single Page</h2>
    <h5>This is an example of a link Post of portfolio image.</h5>
    <div class="search_box">
    <form id="searchform" class="searchform" action="#" method="get">
        <span>
        <input id="s" class="text_input" type="text" onblur="if (this.value == '') {this.value = 'Search..'}" onfocus="if(this.value == 'Search..') {this.value = '';}" name="s" value="Search..">
        </span>
        <input class="search_button" type="submit" value="">
    </form>
    </div>
</section>

<div class="two_third">
<div class="flexslider">
    <ul class="slides">
        <li><img src="${ctxStatic }/mysite/images/portfolio_single_page_img_1.png" alt="img" /></li>
        <li><img src="${ctxStatic }/mysite/images/portfolio_single_page_img_2.png" alt="img" /></li>
        <li><img src="${ctxStatic }/mysite/images/portfolio_single_page_img_3.png" alt="img" /></li>
        <li><img src="${ctxStatic }/mysite/images/portfolio_single_page_img_4.png" alt="img" /></li>
     </ul>
</div>
</div>
<div class="one_third_last">
	<div class="portfolio_single">
		<h4>Title Goes Here</h4>
        <ul>
            <li><strong>Skills Needed:</strong> Photoshop,CSS,HTML</li>
            <li><strong>Client:</strong> Lorem Ipsum</li>
            <li><strong>Project Url:</strong> http//www.yourdomain.com</li>
        </ul>
        <p>Fusce lobortis egestas risus tincidunt facilisis. In hac habitasse platea 
        dictumst. Donec non consequat justo. Sed mollis felis vitae metus euismod feugiat 
        ac a arcu. Suspendisse rutrum tempus sem, eget vulputate orci placerat vitae. Etiam 
        consectetur bibendum turpis, eu cursus quam vehicula ut. Ut faucibus aliquet tellus 
        eget euismod. Nullam sit amet turpis sit amet ipsum sollicitudin euismod imperdiet 
        mattis ante. Pellentesque gravida vestibulum molestie. Proin ultrices dolor vitae 
        metus auctor congue.</p><br />
        <a href="#" class="read_more">Launch Site</a>
    </div>
</div>

</section>
<!--  Content wide end -->

</body>
</html>
