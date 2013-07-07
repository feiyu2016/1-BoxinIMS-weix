<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/modules/cms/front/include/taglib.jsp"%>
<%@ taglib prefix="sitemesh"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!DOCTYPE html>
<html>
<head>
<title><sitemesh:title default="欢迎光临" /> - ${site.title} -
	Powered By 邯郸博信</title>
<%@include file="/WEB-INF/views/modules/cms/front/include/head.jsp"%>
<sitemesh:head />
</head>

<body class="home">
<div id="background_bg"></div>

	<!-- container Start -->
	<section id="container">
		<header>
			<figure id="logo">
				<a href="index.html"><img alt="Logo"
					src="${ctxStatic }/images/logo.jpg" class="img-rounded" width="60"
					height="70">邯郸智讯</a>
			</figure>
			<div class="top_right">
				<ul class="top_info">
					<li><span class=" call_1st_col">电话:</span> <span
						class="call_2nd_col">0310-3298268</span></li>
					<li><span class=" call_1st_col">传真:</span> <span
						class="call_2nd_col">0310-3298268</span></li>
					<li><span class=" call_1st_col">邮箱:</span> <span
						class="call_2nd_col">hdzhixun@163.com</span></li>
				</ul>
				 <span class="call_2nd_col">	致力于打造专业二维码行业平台，竭诚为您提供最完美的解决方案！</span> 
				<div id="social_media" style="display:none">
					<img src="images/rss_icon.png" alt="img" /> <img
						src="images/twitter_icon.png" alt="img" /> <img
						src="images/facebook_icon.png" alt="img" /> <img
						src="images/skype_icon.png" alt="img" /> <img
						src="images/link_in_icon.png" alt="img" />
				</div>
			</div>
		</header>
		<!-- top section end -->


		<!-- Nav start -->
		<nav >
			<div id="myslidemenu" class="jqueryslidemenu clearfix container">
				<ul>
					<li><a class="active" href="index-1.html"><i
							class="icon-home"></i>首页</a></li>
					<c:forEach items="${fnc:getMainNavList(site.id)}" var="category"
						varStatus="status">
						<c:if test="${status.index lt 6}">
							<c:choose>
								<c:when test="${not empty category.href}">
									<c:choose>
										<c:when test="${fn:indexOf(category.href, '://') eq -1}">
											<c:set var="url" value="${ctx}${category.href}" />
										</c:when>
										<c:otherwise>
											<c:set var="url" value="${category.href}" />
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<c:set var="url"
										value="${ctx}/list-${category.id}${fns:getUrlSuffix()}" />
								</c:otherwise>
							</c:choose>
							<li
								class="${requestScope.category.id eq category.id||fn:indexOf(requestScope.category.parentIds,category.id) ge 1?'active':''}"><a
								href="${url}" target="${category.target}"><span>${category.name}</span></a></li>
						</c:if>
					</c:forEach>

				</ul>

				<div>
					<form class="navbar-search pull-right" action="${ctx}/search"
						method="get">
						<input type="text" name="q" maxlength="20"
							class="search-query span2" placeholder="全站搜索..." value="${q}">
					</form>

				</div>
			</div>
		</nav>
		<!-- Nav end -->

	</section>

	<div class="container">
		<div class="container">
			<sitemesh:body />
		</div>
	</div>
	<!-- /container -->
	<hr style="margin: 20px 0 10px;">
	<!--  trigger content start -->
<div class="trigger_container">
    <span class="trigger"><a href="#"></a></span>
    <div class="toggle_container">
        <p>Responsive Layout is powerfull and easy to customize.Quick Contact <strong>templatesden@yourmail.com</strong></p>
    </div>
</div>
	<footer>

		<div class="one_third">
			<div class="widget_container">
				<h4>
					ABOUT <span>US</span>
				</h4>
				<img src="${ctxStatic }/mysite/images/footer_logo.png" alt="img"
					class="alignleft" /> Nullam ultrices suscipit erat, eu suscipit
				diam lacinia id. Quisque diam sapien, euismod eget volutpat sed,
				pharetra a nibh. Praesent a velit eros, id scelerisque ipsum.
				Praesent adipiscing ultrices convallis. Fusce erat neque, porta
				vitae convallis vel, elementum vitae enim. Praesent sit amet erat
				sapien. In metus nisl, ultricies quis facilisis quis, aliquet eget
				magna.
			</div>
		</div>

		<div class="one_third">
			<div class="widget_container">
				<h4>
					RECENT <span>POST</span>
				</h4>
				<ul>
					<li><img
						src="${ctxStatic }/mysite/images/recent_post_img_1.png" alt="img"
						class="thumb_img" />
						<div class="description">
							<strong>Nullam ultrices suscipit</strong><br /> Suscipit diam
							lacinia id quisque diam sapien.
						</div></li>
					<li><img
						src="${ctxStatic }/mysite/images/recent_post_img_2.png" alt="img"
						class="thumb_img" />
						<div class="description">
							<strong>Nullam ultrices suscipit</strong><br /> Euismod eget
							volutpat sed pharetra a nibh.
						</div></li>
				</ul>
			</div>
		</div>

		<div class="one_third_last">
			<div class="widget_container">
				<h4>
					FLICKR <span>PHOTO'S</span>
				</h4>
				<div class="flickr_widget">
					<img src="${ctxStatic }/mysite/images/flickr_img_1.png" alt="img" />
					<img src="${ctxStatic }/mysite/images/flickr_img_2.png" alt="img" />
					<img src="${ctxStatic }/mysite/images/flickr_img_3.png" alt="img" />
					<img src="${ctxStatic }/mysite/images/flickr_img_4.png" alt="img" />
					<img src="${ctxStatic }/mysite/images/flickr_img_5.png" alt="img" />
					<img src="${ctxStatic }/mysite/images/flickr_img_6.png" alt="img" />
				</div>
			</div>
		</div>

		<div class="container row-fluid ">
			<div class="footer_nav">
				<a href="${ctx}/guestbook" target="_blank">公共留言</a> | <a
					href="${ctx}/search" target="_blank">全站搜索</a> | <a
					href="${ctx}/map-${site.id}${fns:getUrlSuffix()}" target="_blank">站点地图</a>
				| <a href="mailto:thinkgem@163.com">技术支持</a> | <a
					href="${pageContext.request.contextPath}${fns:getAdminPath()}"
					target="_blank">业务管理</a>
			</div>

		</div>



		<section class="footer">
			<div class="copyright">
				<p>&copy; Copyright &copy; 2013.邯郸博信 All rights reserved.
				<div class="pull-right">${fns:getDate('yyyy年MM月dd日 E')}</div>
				<div class="copyright">${site.copyright}</div>
			</div>
			</p>
		</section>

	</footer>


</body>
</html>