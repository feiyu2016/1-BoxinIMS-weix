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
<!-- 

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
 -->

<div class="two_third">
	
    <img src="<c:if test="${category.image eq '' }">${ctxStatic }/mysite/images/blog_img_1.png</c:if> <c:if test="${category.image ne '' }">${category.image }</c:if>" alt="img" class="alignleft" />
    <h3><span>${category.name }</span></h3>
    <p>简介:${category.desciption}</p><br />
    
    <span class="divider"></span>
    
    <c:forEach items="${categoryMap}" var="map" varStatus="status">
	   	  ${status.index % 2 eq 0  ? '<div>':'<div>'}
			 <div class="drop_cap thumb_img"><h3 style="color:white">${status.index+1} </h3></div>
			 	<div class="description">
				<h4><small><a href="${ctx}/list-${map.key.id}${urlSuffix}" class="pull-right">更多&gt;&gt;</a></small>${map.key.name}</h4>
				<c:if test="${map.key.module eq 'article'}">
					<ul><c:forEach items="${map.value}" var="article">
						<li><span class="pull-right"><fmt:formatDate value="${article.updateDate}" pattern="yyyy.MM.dd"/></span><a href="${ctx}/view-${article.category.id}-${article.id}${urlSuffix}" style="color:${article.color}">${fns:abbr(article.title,70)}</a></li>
					</c:forEach></ul>
				</c:if>
				<c:if test="${map.key.module eq 'link'}">
					<ul><c:forEach items="${map.value}" var="link">
						<li><a href="${link.href}" target="_blank" style="color:${link.color}"><c:out value="${link.title}" /></a></li>
					</c:forEach></ul>
				</c:if>
			 </div>
		  ${status.index % 2 ne 0 ? '</div>':'</div>'}
		  <c:if test="${empty map.value }">
					<div style="margin-top:50px"></div>
		  </c:if>
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


</body>
</html>
