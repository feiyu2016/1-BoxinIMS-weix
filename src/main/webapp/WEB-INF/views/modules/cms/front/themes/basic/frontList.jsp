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
							                 
							            </span>
							         <span class="post_meta_info">
							            <span class="post_date">
							                <strong><fmt:formatDate
									value="${article.updateDate}" pattern="yyyy.MM.dd" /></strong>
							            </span>
							            <span class="post_author">
							                <strong>${article.user.name }</strong>
							            </span>     
							        </span>
							    </div>
							    <div class="two_third_last">
							        <h4><a href="#">${fns:abbr(article.title,96)}</a></h4>       
							        <p>${article.desciption}</p><br />
							        <a href="${ctx}/view-${article.category.id}-${article.id}${urlSuffix}" class="btn">详细信息</a>
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



</aside>
</div>

</section>
<!--  Content wide end -->



</body>
</html>
