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
</head>
<body>


<!--  Content wide start -->
<section class="content">

<section class="sub_header">
    <h2>About Us</h2>
    <h5>The Company Details and Specialization and Latest News</h5>
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
    <img src="${ctxStatic }/mysite/images/about_us_img_1.png" alt="img" class="alignleft" />
    <h3>About Our <span>Company</span></h3>
    <p>Etiam magna libero dapibus eu suscipit condimentum fringilla mattis ligula. 
    Morbi eget sem nunc. Ut felis ipsum mollis a ultrices id condimentum ac odio. 
    Nam id velit non dui cursus aliquam. Vestibulum ante ipsum primis in faucibus orci 
    luctus et ultrices posuere cubilia Curae Nulla facilisi. Praesent nec dolor non 
    eros tempus mollis. Maecenas feugiat facilisis ipsum at pellentesque. Sed dolor 
    ipsum feugiat non euismod at pulvinar ut sem. Maecenas id ante quam. 
    Class aptent taciti sociosq.</p><br />
    <a href="#" class="read_more">Read More</a>
    
    <span class="divider"></span>
    
    <h3>What Makes <span>Us Special</span></h3><br />
    <c:forEach items="${categoryMap}" var="map" varStatus="status">
	   	  ${status.index % 2 eq 0    ? '<div class="one_half">':'<div class="one_half_last">'}
			 <div class="drop_cap thumb_img"><h3 style="color:white">${status.index+1} </h3></div>
			 	<div class="description">
				<h4><small><a href="${ctx}/list-${map.key.id}${urlSuffix}" class="pull-right">更多&gt;&gt;</a></small>${map.key.name}</h4>
				<c:if test="${map.key.module eq 'article'}">
					<ul><c:forEach items="${map.value}" var="article">
						<li><span class="pull-right"><fmt:formatDate value="${article.updateDate}" pattern="yyyy.MM.dd"/></span><a href="${ctx}/view-${article.category.id}-${article.id}${urlSuffix}" style="color:${article.color}">${fns:abbr(article.title,40)}</a></li>
					</c:forEach></ul>
				</c:if>
				<c:if test="${map.key.module eq 'link'}">
					<ul><c:forEach items="${map.value}" var="link">
						<li><a href="${link.href}" target="_blank" style="color:${link.color}"><c:out value="${link.title}" /></a></li>
					</c:forEach></ul>
				</c:if>
			 </div>
		  ${status.index % 2 ne 0 ? '</div>':''}
	</c:forEach>
</div>   
    

<div class="one_third_last">
<aside>

<div class="widget_container">
    <h3><span>栏目列表</span></h3>
    <ul>
    	 <c:forEach items="${categoryList}" var="category">
			 
				<li><a href="${ctx}/list-${category.id}${urlSuffix}">${category.name}</a></li>
			 </c:forEach>
			 
    </ul>
</div>

</aside>
</div>

</section>










<!-- ########################################### -->





	<div class="row">
	   <div class="span10">
	   	  <c:forEach items="${categoryMap}" var="map" varStatus="status">
	   	  ${status.index % 2 eq 0 ? '<div class="row">':''}
			 <div class="span5">
				<h4><small><a href="${ctx}/list-${map.key.id}${urlSuffix}" class="pull-right">更多&gt;&gt;</a></small>${map.key.name}</h4>
				<c:if test="${map.key.module eq 'article'}">
					<ul><c:forEach items="${map.value}" var="article">
						<li><span class="pull-right"><fmt:formatDate value="${article.updateDate}" pattern="yyyy.MM.dd"/></span><a href="${ctx}/view-${article.category.id}-${article.id}${urlSuffix}" style="color:${article.color}">${fns:abbr(article.title,40)}</a></li>
					</c:forEach></ul>
				</c:if>
				<c:if test="${map.key.module eq 'link'}">
					<ul><c:forEach items="${map.value}" var="link">
						<li><a href="${link.href}" target="_blank" style="color:${link.color}"><c:out value="${link.title}" /></a></li>
					</c:forEach></ul>
				</c:if>
			 </div>
		  ${status.index % 2 ne 0 ? '</div>':''}
		  </c:forEach>
	   </div>
	</div>
</body>
</html>
