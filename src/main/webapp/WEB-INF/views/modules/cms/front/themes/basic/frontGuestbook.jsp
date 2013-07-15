<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/modules/cms/front/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>首页</title>
	<meta name="decorator" content="cms_default_${site.theme}"/>
	<meta name="description" content="JeeSite ${site.desciption}" />
	<meta name="keywords" content="JeeSite ${site.keywords}" />
	<link href="${ctxStatic}/jquery-validation/1.11.0/jquery.validate.min.css" type="text/css" rel="stylesheet" />
	<script src="${ctxStatic}/jquery-validation/1.11.0/jquery.validate.min.js" type="text/javascript"></script>
	<script src="${ctxStatic}/jquery-validation/1.11.0/jquery.validate.method.min.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			<c:if test="${not empty message}">alert("${message}");</c:if>
			$("#inputForm").validate({
				rules: {
					validateCode: {remote: "${pageContext.request.contextPath}/servlet/validateCodeServlet"}
				},
				messages: {
					content: {required: "请填写留言内容"},
					validateCode: {remote: "验证码不正确"}
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					if (element.is(":checkbox")||element.is(":radio")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
			$("#main_nav li").each(function(){
				$(this).toggleClass("active", $(this).text().indexOf('公共留言')>=0);
			});
		});
		function page(n,s){
			location="${ctx}/guestbook?pageNo="+n+"&pageSize="+s;;
		}
	</script>
</head>
<body>



<!--  Content wide start -->
<section class="content">
<section >
<div class="two_third">
    <iframe width="95%" height="350" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="http://ditu.google.cn/maps?f=q&amp;source=s_q&amp;hl=zh-CN&amp;geocode=&amp;q=%E9%82%AF%E9%83%B8%E5%B8%82%E4%BA%BA%E6%B0%91%E8%B7%AF++%E4%BA%BA%E6%B0%91%E4%B8%9C%E8%B7%AF12%E5%8F%B7++%E9%87%91%E5%B8%9D%E8%B1%AA%E5%A4%A7%E9%85%92%E5%BA%97&amp;aq=&amp;sll=36.611161,114.481686&amp;sspn=0.002407,0.005284&amp;brcurrent=3,0x35dc39cf614428cf:0x2179a2d2f5b7ada,0,0x35dc365cded504ff:0xd32b0a77c8249cef%3B5,0,0&amp;ie=UTF8&amp;hq=%E4%BA%BA%E6%B0%91%E8%B7%AF+%E4%BA%BA%E6%B0%91%E4%B8%9C%E8%B7%AF12%E5%8F%B7+%E9%87%91%E5%B8%9D%E8%B1%AA%E5%A4%A7%E9%85%92%E5%BA%97&amp;hnear=%E6%B2%B3%E5%8C%97%E7%9C%81%E9%82%AF%E9%83%B8%E5%B8%82&amp;ll=36.610972,114.480721&amp;spn=0.03219,0.128401&amp;t=m&amp;output=embed"></iframe><br /><small><a href="http://ditu.google.cn/maps?f=q&amp;source=embed&amp;hl=zh-CN&amp;geocode=&amp;q=%E9%82%AF%E9%83%B8%E5%B8%82%E4%BA%BA%E6%B0%91%E8%B7%AF++%E4%BA%BA%E6%B0%91%E4%B8%9C%E8%B7%AF12%E5%8F%B7++%E9%87%91%E5%B8%9D%E8%B1%AA%E5%A4%A7%E9%85%92%E5%BA%97&amp;aq=&amp;sll=36.611161,114.481686&amp;sspn=0.002407,0.005284&amp;brcurrent=3,0x35dc39cf614428cf:0x2179a2d2f5b7ada,0,0x35dc365cded504ff:0xd32b0a77c8249cef%3B5,0,0&amp;ie=UTF8&amp;hq=%E4%BA%BA%E6%B0%91%E8%B7%AF+%E4%BA%BA%E6%B0%91%E4%B8%9C%E8%B7%AF12%E5%8F%B7+%E9%87%91%E5%B8%9D%E8%B1%AA%E5%A4%A7%E9%85%92%E5%BA%97&amp;hnear=%E6%B2%B3%E5%8C%97%E7%9C%81%E9%82%AF%E9%83%B8%E5%B8%82&amp;ll=36.610972,114.480721&amp;spn=0.03219,0.128401&amp;t=m" style="color:#0000FF;text-align:left">查看大图</a></small>
</div>
<div class="one_third_last">
	<h4>公司位置</h4>
<br />
<div class="contact_details">
    <div class="thumb_img contact_identify">
        <img src="${ctxStatic }/mysite/images/home.png" alt="img"/>
    </div>
    <div class="description">
        <h5>地址</h5><br />
        <p>公司地址：人民路金帝豪B座1108室</p>
    </div>
</div>

<span class="divider"></span>

<div class="contact_details">
<aside>
	<div>
    <div class="thumb_img contact_identify">
        <img src="${ctxStatic }/mysite/images/phone.png" alt="img"/>
    </div>
    <div class="description">
        <h5>联系电话</h5><br />
        <p><strong>固话:</strong>0310-3298268</p>
        <p><strong>手机:</strong>13784017885</p>
    </div>
</div>

<span class="divider"></span>

<div class="contact_details">
    <div class="thumb_img contact_identify">
        <img src="${ctxStatic }/mysite/images/mail.png" alt="img"/>
    </div>
    <div class="description">
        <h5>公司邮箱</h5><br />
        <p><strong>Email:&nbsp;&nbsp;</strong>hdzhixun@163.com</p>
    </div>
</div>

</aside>
</div>
</div>

</section>
<br /><br /><br />
    
<div class="two_third" style="display:none">
    <form:form id="contact-form"   name="myform"  action="" method="post" class="form-horizontal" >	
        <div id="main">
        <div id="response" /></div>
            <label for="name">姓名:</label>
            <p><input type="text" name="name" maxlength="11" class="required"/></p>
            
            <label for="email">邮箱:</label>
            <p><input type="text" name="email" maxlength="50" class="required email"   /></p>
            
            <label for="web">电话:</label>
            <p><input type="text" name="phone" maxlength="50" class="required phone" /></p>
            
            <label for="web">单位:</label>
            <p><input type="text" name="workunit" maxlength="50" class="required" /></p>
            
            <label for="web">留言分类:</label>
            <p>
            	<select name="type" class="txt required" style="width:100px;">
						<option value="">请选择</option>
						<c:forEach items="${fns:getDictList('cms_guestbook')}" var="type">
							<option value="${type.value}">${type.label}</option>
						</c:forEach>
					</select>
            </p>
            
            
            <label for="message">内容:</label>
            <p><textarea name="content"  id="message" cols="30" rows="10"></textarea></p>
            <label for="web">验证码:</label>
            <p><tags:validateCode name="validateCode" /></p>
            <p><input  class="contact_button button" type="submit" name="submit" id="submit" value="提交" /></p>
        </div>
    </form:form>
</div>
    
<div class="one_third_last">
<aside>


    
</section>
<!--  Content wide end -->

</body>
</html>