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

<div id="background_bg_inner"></div>
<div class="demo">
<ul id="list" class="image-grid">
    <li data-id="id-1" class="buisness">
        <div class="portfolio_content">
        	<span class="pf_img_br"></span>
              <img src="${ctxStatic }/mysite/images/portfolio_4col_img_10.png" alt="img" />          
            <h4><a href="portfolio_single_page.html">Lemon Water</a></h4>
            <p>Blandit Varius</p>
            <div class="link_btn">
                <a href="${ctxStatic }/mysite/images/portfolio_1col_img_1.png" class="zoom example6"></a>
                <a href="portfolio_single_page.html" class="link_post"></a>
                <div class="overlay"></div>
            </div>
        </div>
    </li>
    <li data-id="id-2" class="logo">
        <div class="portfolio_content">
        <span class="pf_img_br"></span>
            <img src="${ctxStatic }/mysite/images/portfolio_4col_img_12.png" alt="img" />     
            <h4><a href="portfolio_single_page.html">The Management</a></h4>
            <p>Duis dignissim</p>
            <div class="link_btn">
                <a href="${ctxStatic }/mysite/images/portfolio_5F3col_img_2.png" class="zoom example6"></a>
                <a href="portfolio_single_page.html" class="link_post"></a>
                <div class="overlay"></div>
            </div>
        </div>
    </li>
    <li data-id="id-3" class="logo">
        <div class="portfolio_content">
        <span class="pf_img_br"></span>
            <img src="${ctxStatic }/mysite/images/portfolio_4col_img_3.png" alt="img" />
            <h4><a href="portfolio_single_page.html">Sun Glasses</a></h4>
            <p>Curabitur</p>
            <div class="link_btn">
                <a href="${ctxStatic }/mysite/images/portfolio_2col_img_3.png" class="zoom example6"></a>
                <a href="portfolio_single_page.html" class="link_post"></a>
                <div class="overlay"></div>
            </div>
        </div>
    </li>
    <li data-id="id-4" class="logo">
        <div class="portfolio_content">
        <span class="pf_img_br"></span>
            <img src="${ctxStatic }/mysite/images/portfolio_4col_img_4.png" alt="img" />
            <h4><a href="portfolio_single_page.html">Water Splash</a></h4>
            <p>Ornare luctus</p>
            <div class="link_btn">
                <a href="${ctxStatic }/mysite/images/portfolio_5F3col_img_4.png" class="zoom example6"></a>
                <a href="portfolio_single_page.html" class="link_post"></a>
                <div class="overlay"></div>
            </div>
        </div>
    </li>
    <li data-id="id-5" class="buisness">
        <div class="portfolio_content">
        <span class="pf_img_br"></span>
            <img src="${ctxStatic }/mysite/images/portfolio_4col_img_5.png" alt="img" />
            <h4><a href="portfolio_single_page.html">Project Explanation</a></h4>
            <p>Vestibulum</p>
            <div class="link_btn">
                <a  href="${ctxStatic }/mysite/images/portfolio_5F3col_img_5.png" class="zoom example6"></a>
                <a href="portfolio_single_page.html" class="link_post"></a>
                <div class="overlay"></div>
            </div>
        </div>
    </li>
    <li data-id="id-6" class="logo">
        <div class="portfolio_content">
        <span class="pf_img_br"></span>
            <img src="${ctxStatic }/mysite/images/portfolio_4col_img_6.png" alt="img" />
            <h4><a href="portfolio_single_page.html">Scribilling Pad</a></h4>
            <p>Sagittis turpis</p>
            <div class="link_btn">
                <a href="${ctxStatic }/mysite/images/portfolio_2col_img_6.png" class="zoom example6"></a>
                <a href="portfolio_single_page.html" class="link_post"></a>
                <div class="overlay"></div>
            </div>
        </div>
    </li>
    <li data-id="id-7" class="logo">
        <div class="portfolio_content">
        <span class="pf_img_br"></span>
            <img src="${ctxStatic }/mysite/images/portfolio_4col_img_7.png" alt="img" />
            <h4><a href="portfolio_single_page.html">Envato Flash</a></h4>
            <p>Vulputate pretium</p>
            <div class="link_btn">
                <a href="${ctxStatic }/mysite/images/portfolio_5F3col_img_7.png" class="zoom example6"></a>
                <a href="portfolio_single_page.html" class="link_post"></a>
                <div class="overlay"></div>
            </div>
        </div>
    </li>
    <li data-id="id-8" class="buisness">
        <div class="portfolio_content">
        <span class="pf_img_br"></span>
            <img src="${ctxStatic }/mysite/images/portfolio_4col_img_8.png" alt="img" />
            <h4><a href="portfolio_single_page.html">Working Women</a></h4>
            <p>Gravida</p>
            <div class="link_btn">
                <a href="${ctxStatic }/mysite/images/portfolio_5F3col_img_8.png" class="zoom example6"></a>
                <a href="portfolio_single_page.html" class="link_post"></a>
                <div class="overlay"></div>
            </div>
        </div>
    </li>
    <li data-id="id-9" class="logo">
        <div class="portfolio_content">
        <span class="pf_img_br"></span>
            <img src="${ctxStatic }/mysite/images/portfolio_4col_img_9.png" alt="img" />
            <h4><a href="portfolio_single_page.html">Art Logo</a></h4>
            <p>Vestibulum</p>
            <div class="link_btn">
                <a href="${ctxStatic }/mysite/images/portfolio_5F3col_img_9.png" class="zoom example6"></a>
                <a href="portfolio_single_page.html" class="link_post"></a>
                <div class="overlay"></div>
            </div>
        </div>
    </li>
    <li data-id="id-10" class="logo">
        <div class="portfolio_content">
        <span class="pf_img_br"></span>
              <img src="${ctxStatic }/mysite/images/portfolio_4col_img_1.png" alt="img" />
            <h4><a href="portfolio_single_page.html">Project Thinking</a></h4>
            <p>Molestie</p>
            <div class="link_btn">
                <a href="${ctxStatic }/mysite/images/portfolio_4col_img_10.png" class="zoom example6"></a>
                <a href="portfolio_single_page.html" class="link_post"></a>
                <div class="overlay"></div>
            </div>
        </div>
    </li>
    <li data-id="id-11" class="buisness">
        <div class="portfolio_content">
        <span class="pf_img_br"></span>
            <img src="${ctxStatic }/mysite/images/portfolio_4col_img_11.png" alt="img" />
            <h4><a href="portfolio_single_page.html">Happy Shopping</a></h4>
            <p>Proin ultrices</p>
            <div class="link_btn">
                <a href="${ctxStatic }/mysite/images/portfolio_4col_img_11.png" class="zoom example6"></a>
                <a href="portfolio_single_page.html" class="link_post"></a>
                <div class="overlay"></div>
            </div>
        </div>
    </li>
    <li data-id="id-12" class="logo">
        <div class="portfolio_content">
        <span class="pf_img_br"></span>
                   <img src="${ctxStatic }/mysite/images/portfolio_4col_img_2.png" alt="img" />
            <h4><a href="portfolio_single_page.html">The Banana</a></h4>
            <p>Tristique dolor</p>
            <div class="link_btn">
                <a href="${ctxStatic }/mysite/images/portfolio_4col_img_12.png" class="zoom example6"></a>
                <a href="${ctx}/picdeta-${category.id}${urlSuffix}" class="link_post"></a>
                <div class="overlay"></div>
            </div>
        </div>
    </li>
</ul>
</div>

</section>
<!--  Content wide end -->

</body>
</html>
