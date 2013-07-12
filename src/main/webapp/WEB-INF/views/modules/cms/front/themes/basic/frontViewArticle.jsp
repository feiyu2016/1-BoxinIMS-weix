<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/modules/cms/front/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>${article.title} - ${category.name}</title>
	<meta name="decorator" content="cms_default_${site.theme}"/>
	<meta name="description" content="${article.desciption} ${category.desciption}" />
	<meta name="keywords" content="${article.keywords} ${category.keywords}" />
	<script type="text/javascript">
		$(document).ready(function() {
			if ("${category.allowComment}"=="1" && "${article.articleData.allowComment}"=="1"){
				$("#comment").show();
				page(1);
			}
		});
		function page(n,s){
			$.get("${ctx}/comment",{theme: '${category.site.theme}', module: '${category.module}',
				contentId: '${article.id}', title: '${article.title}', pageNo: n, pageSize: s, date: new Date().getTime()
			},function(data){
				$("#comment").html(data);
			});
		}
	</script>
</head>
<body>
	
<!--  Content wide start -->
<section class="content">

<div class="two_third">
    <img src="<c:if test="${article.thumb eq '' }">${ctxStatic }/mysite/images/blog_img_1.png</c:if> <c:if test="${article.thumb ne '' }">${article.thumb }</c:if>" alt="img" class="alignleft" />
    
    <h3><span>${article.title}</span></h3>
    <p>摘要：${article.desciption}</p>
    <br />
    
    
    <div style="border-top:1px solid #ddd;padding:10px;margin:25px 0;">发布者：${article.user.name} &nbsp; 点击数：${article.hits} &nbsp; 发布时间：<fmt:formatDate value="${article.inputDate}" pattern="yyyy-MM-dd HH:mm:ss"/> &nbsp; 更新时间：<fmt:formatDate value="${article.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/></div>
    
    <div>${article.articleData.content}</div>
    
			<div id="comment" class="hide span10">
				正在加载评论...
			</div>
</div>



<div class="one_third_last">
<aside>

<div class="widget_container">
<h3>  <span>栏目列表</span></h3>
<ul>
		
	<c:forEach items="${categoryList}" var="category">
			<li><a href="${ctx}/list-${category.id}${urlSuffix}">${category.name}</a></li>
		</c:forEach>		 
</ul>
</div>

<div class="widget_container">
<h3>相关 <span>文章</span></h3>
<ul>
	<c:forEach items="${relationList}" var="relation">
				<li style="float:left;width:230px;"><a href="${ctx}/view-${relation[0]}-${relation[1]}${urlSuffix}">${fns:abbr(relation[2],30)}</a></li>
	</c:forEach>
</ul>
</div>



</aside>
</div>


<!-- --------------------------------------- -->
   
   </section>
</body>
</html>
