<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/modules/cms/front/include/taglib.jsp"%>
<%@ taglib prefix="sitemesh"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><sitemesh:title default="欢迎光临" /> - ${site.title} -
	Powered By 邯郸博信</title>
<%@include file="/WEB-INF/views/modules/cms/front/include/head.jsp"%>
<sitemesh:head />
</head>

<body class="home">
<div id="background_bg"></div>
	<!-- container Start -->
	<section id="container" style="width:1100px;margin-top:1px;">
					<div align="right"> 
						<ul class="top_info">
				            <li> <a >微信营销服务</a></li>
				            <li> <a href="http://2weima.hdzhx.com/users/login" target="_blank">移动平台服务</a></li>
		        		 </ul>
						<ul class="top_logo" >
				            <li style="margin-left:1px;" > <img alt="" src="${ctxStatic }/images/logo.png"   class="img-rounded" style="width:120px;height:55px"></li>
				            <li style="margin-right:40px;"><img alt="" src="${ctxStatic }/mysite/images/360anquan.jpg"  class="img-rounded" style="width:120px;height:55px"></li>
				            <li> <img alt="" src="${ctxStatic }/mysite/images/header_right_top.png" style="margin-top:10px;"></li>
		        		 </ul>
							
					</div>
		<!-- top section end -->

 	
		<!-- Nav start -->
		<nav>
			<div id="myslidemenu" class="jqueryslidemenu clearfix container" style="width:1100px;">
				<ul>
					<c:forEach items="${fnc:getMainNavList(site.id)}" var="category"
						varStatus="status">
						<c:if test="${status.index lt 10}">
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
							<li> <a id="${category.id }"   class="${requestScope.category.id eq category.id || ( empty requestScope.category.name && category.name eq '首页')  ||  fn:indexOf(requestScope.category.parentIds,category.id) ge 1?'active':''}"
								href="${url}" target="${category.target}"><i class="icon-${category.icon }"></i><span>${category.name}</span></a>
								
								<%/**********
									暂不显示二级菜单
									<c:if test="${ not empty fnc:getCategoryList(site.id,category.id,5,'menuparam') }">
										<ul>
										<c:forEach items="${fnc:getCategoryList(site.id,category.id,5,'menuparam')}" var="child"
										varStatus="status">
										<c:set var="childUrl"
														value="${ctx}/list-${child.id}${fns:getUrlSuffix()}" />
												<li><a
												href="${childUrl}" target="${child.target}"><span>${child.name}</span></a></li>
										</c:forEach>
										</ul>
									</c:if>	
								
								
								**********/ %>
								
							</li>
							
						</c:if >
						
					</c:forEach>

				</ul>

				<div style="display:none">
					<form class="navbar-search pull-right" action="${ctx}/search"
						method="get">
						<input type="text" name="q" maxlength="20"
							class="search-query span2" placeholder="全站搜索..." value="${q}">
					</form>

				</div>
			</div>
		</nav>
		<!-- Nav end -->

			<sitemesh:body />
	<!-- /container -->
	<!--  trigger content start -->


</section>
		<div class="trigger_container">
			<span class="trigger"><a href="#"></a></span>
			<div class="toggle_container">
				<p>
					邯郸智讯二维码服务平台打造专业优质秀平台
					<strong>hdzhixun@163.com</strong>
				</p>
			</div>
		</div>
	<footer>


		<div class="one_third">
			<div class="widget_container">
				<img src="${ctxStatic }/images/logo.png" alt="img"
					class="alignleft" /> 邯郸智讯二维码，在二维码识读及相关高新技术应用研发方面有雄厚的实力。其核心团队是由移动互联网、图像识别、数据算法、软件技术、市场营销等领域的资深人员组成，致力于为邯郸手机用户提供上乘的产品服务体验。
      邯郸智讯二维码，致力于从客户角度出发，不拘于普通的模式话应用，为客户提供详尽的解决方案，让我们共同享受科技带来的便捷和震撼！
      我们的业务范围：电子凭证、富媒体广告、防伪溯源、会议签到、系统集成、软件开发、数据分析、语音呼叫、群发短信、网路安全、无线连接等.
			</div>
		</div>

		<div class="one_third">
			<div class="widget_container">
				<ul>
					<li><img
						src="${ctxStatic }/mysite/images/partner_jindianzi.png" alt="img"
						class="thumb_img" width="92px" height="56px"  style="width:92px;height:56px"/>
						<div class="description">
							<strong>金点子传媒</strong><br /> 智讯移动互联与金点子传媒打造邯郸新媒体，新体验，新生活的综合应用平台
						</div></li>
					<li><img
						src="${ctxStatic }/mysite/images/partner_kaoyan.jpg" alt="img"
						class="thumb_img"  width="92px" height="56px" style="width:92px;height:56px"/>
						<div class="description">
							<strong>烤宴自助烧烤主题餐厅</strong><br /> 
						</div></li>
					<li><img
						src="${ctxStatic }/mysite/images/partner_bitebao.jpg" alt="img"
						class="thumb_img" width="92px" height="56px"  style="width:92px;height:56px"/>
						<div class="description">
							<strong>比特堡啤酒健康烤肉</strong><br />
						</div></li>
				</ul>
			</div>
		</div>

		<div class="one_third_last">
			<div class="widget_container">
				<div class="flickr_widget">
					<img alt="" src="${ctxStatic }/mysite/images/2weima.png" width="90px;" height="90px;"   style="margin-right:10px; width:90px;height:90px ">	
				</div>
			</div>
		</div>

		<div class="container row-fluid ">
			<div class="footer_nav">
				<a href="${ctx}/guestbook" target="_blank">公共留言</a> | <a
					href="${ctx}/search" target="_blank">全站搜索</a> | <a
					href="${ctx}/map-${site.id}${fns:getUrlSuffix()}" target="_blank">站点地图</a>
				| <a href="mailto:hdzhixun@163.com">技术支持</a> | <a
					href="${pageContext.request.contextPath}${fns:getAdminPath()}"
					target="_blank">业务管理</a>
			</div>

		</div>

		<section class="footer">
			<div class="copyright">
				<p>&copy; Copyright &copy; 2013.邯郸博信 All rights reserved.    ${fns:getDate('yyyy年MM月dd日 ')}    冀ICP备1301087</p>
				<p><a href="http://www.cnzz.com/stat/website.php?web_id=5203923" target="_blank" title="站长统计"><img border="0" hspace="0" vspace="0" src="http://icon.cnzz.com/pic1.gif"></a>
					<a href="http://tongji.baidu.com/hm-web/welcome/ico?s=176b323eb4f479f4d418d2263cf74be9" target="_blank"><img border="0" src="http://eiv.baidu.com/hmt/icon/21.gif" width="20" height="20"></a>
				</p>
			</div>
		</section>

	</footer>


</body>
</html>