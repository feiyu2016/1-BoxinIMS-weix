<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/modules/cms/front/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>${category.name}</title>
	<meta name="decorator" content="cms_default_${site.theme}"/>
	<meta name="description" content="${category.desciption}" />
	<meta name="keywords" content="${category.keywords}" />
</head>
<body>


<!-- ------------------------------------------------- -->


<!--  Content wide start -->
<section class="content">


<div class="two_third">


			<c:if test="${category.module eq 'article'}">
					<c:forEach items="${page.list}" var="article">
							<span class="divider">&nbsp;</span>
								<div class="blog_element">
							    <div class="one_third">
							        <img src="<c:if test="${article.thumb eq '' }">${ctxStatic }/mysite/images/blog_img_1.png</c:if> <c:if test="${article.thumb ne '' }">${article.thumb}</c:if>" alt="img" /><br />
							         <span class="post_comment">
							                <strong><a href="#">2</a></strong> Comments
							            </span>
							         <span class="post_meta_info">
							            <span class="post_date">
							                <strong><fmt:formatDate
									value="${article.updateDate}" pattern="yyyy.MM.dd" /></strong>
							            </span>
							            <span class="post_author">
							                <strong>Admin</strong>
							            </span>     
							        </span>
							    </div>
							    <div class="two_third_last">
							        <h4><a href="#">${fns:abbr(article.title,96)}</a></h4>       
							        <p>${article.desciption}</p><br />
							        <a href="#" class="btn">详细信息</a>
							    </div>
							</div>
						
					</c:forEach>
				<span class="divider">&nbsp;</span>
				<div class="pagination">${page}</div>
				<script type="text/javascript">
					function page(n, s) {
						location = "${ctx}/list-${category.id}${urlSuffix}?pageNo="
								+ n + "&pageSize=" + s;
					}
				</script>
				
			</c:if>
			<c:if test="${category.module eq 'link'}">
			
				<ul>
					<c:forEach items="${page.list}" var="link">
						<li><a href="${link.href}" target="_blank"
							style="color:${link.color}"><c:out value="${link.title}" /></a></li>
					</c:forEach>
				</ul>
				
			</c:if>




</div>


<div class="one_third_last">
<aside>

<div class="widget_container">
<h3>  <span>类别</span></h3>
<ul>
		
	<c:forEach items="${categoryList}" var="category">
			<li><a href="${ctx}/list-${category.id}${urlSuffix}">${category.name}</a></li>
		 </c:forEach>
</ul>
</div>

<div class="widget_container">
<h3>Recent <span>Comments</span></h3>
<ul>
	<li><a href="#">Pellentesque suscipit.</a></li>
    <li><a href="#">Turpis eget ante rhoncus.</a></li>
    <li><a href="#">Imperdiet lobortis venenatis.</a></li>
    <li><a href="#">Bibendum ornare congue.</a></li>
    <li><a href="#">Integer vel nulla eget.</a></li>
    <li><a href="#">Lacinia posuere lorem.</a></li>
    <li><a href="#">Accumsan ipsum bibendum in.</a></li>
</ul>
</div>

<div class="widget_container">
<h3>tags</h3>
<div class="tagcloud">
    <a href="#">amazing</a>
    <a href="#">blog</a>
    <a href="#">greenstar</a>
    <a href="#">nice</a>
    <a href="#">only</a>
    <a href="#">plugins</a>
</div>
</div>

<div class="widget_container">
<h3>Recent <span>Categories</span></h3>
<ul>
	<li><a href="#">Portfolio</a></li>
    <li><a href="#">Web Design</a></li>
    <li><a href="#">Latest News</a></li>
    <li><a href="#">Blog</a></li>
</ul>
</div>

</aside>
</div>

</section>
<!--  Content wide end -->



</body>
</html>
