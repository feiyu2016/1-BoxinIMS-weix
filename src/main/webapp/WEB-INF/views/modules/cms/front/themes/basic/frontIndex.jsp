<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/modules/cms/front/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/modules/cms/front/include/head.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>首页</title>
	<meta name="decorator" content="cms_default_${site.theme}"/>
	<meta name="description" content="JeeSite ${site.desciption}" />
	<meta name="keywords" content="JeeSite ${site.keywords}" />
</head>

<body>

<!-- Elastic Slider Start -->
<div id="ei-slider" class="ei-slider">
    <ul class="ei-slider-large">
        <li>
            <img src="${ctxStatic }/mysite/images/slider_img_1.png" alt="img" />
            <div class="ei-title">
                <h2>最优秀的 <span>二维码</span> 服务平台</h2>
                <h3>提供最完善的解决方案.</h3>
                <h3>提供满足您需要的解决方案.</h3>
            </div>
        </li>
        <li> 
            <img src="${ctxStatic }/mysite/images/slider_img_2.png" alt="img" />
            <div class="ei-title">
                <h2>简洁 <span>高效</span>定制 <span>数据安全</span> </h2>
                <h3>提供最最简洁高效的服务，保证用户个性化定制需求， </h3>
                <h3>提供安全的数据服务， </h3>
            </div>
        </li>
        <li>  
            <img src="${ctxStatic }/mysite/images/slider_img_3.png" alt="img" />
            <div class="ei-title">
                <h2><span>您最需要</span>的 <span>解决方案</span> !</h2>
                <h3>根据您的业务流程，制定最完善的解决方案.</h3>
            </div>
        </li>
    </ul>
    <ul class="ei-slider-thumbs">
        <li class="ei-slider-element">Current</li>
        <li><a href="#">Slide 1</a></li>
        <li><a href="#">Slide 2</a></li>
        <li><a href="#">Slide 3</a></li>
    </ul>
</div>
<div class="clear"></div>
<!-- Elastic Slider end -->



<!-- teaser content start -->
<section class="teaser">
    <div class="one_third">
    
        <h3>最优质的 <span>服务</span></h3>
        Duis dignissim blandit varius. Curabitur adipiscing ornare luctus. 
        Vestibulum venenatis sagittis turpis, eu varius enim vulputate pretium. 
        Sed eget leo sed diam aliquam interdum ut auctor erat. Suspendisse vitae 
        velit leo, et pulvinar velit.
        <span class="teaser_icon">
        <img src="${ctxStatic }/mysite/images/paper_plane.png" alt="img" />
        </span>
    </div>
    <div class="one_third">
        <h3>最高效的 <span>技术支持</span></h3>
        Interdum dignissim blandit varius. Curabitur adipiscing ornare luctus. 
        Vestibulum venenatis sagittis turpis, eu varius enim vulputate pretium. 
        Sed eget leo sed diam aliquam interdum ut auctor erat. Suspendisse vitae 
        velit leo, et pulvinar leo.
        <span class="teaser_icon">
        <img src="${ctxStatic }/mysite/images/wheel.png" alt="img" />
        </span>
    </div>
    <div class="one_third_last">
        <h3>最全面的 <span>解决方案</span></h3>
        Suspendisse dignissim blandit varius. Curabitur adipiscing ornare luctus. 
        Vestibulum venenatis sagittis turpis, eu varius enim vulputate pretium. 
        Sed eget leo sed aliquam interdum ut auctor erat. Suspendisse vitae 
        velit leo, et pulvinar diam.
        <span class="teaser_icon">
        <img src="${ctxStatic }/mysite/images/chart.png" alt="img" />
        </span>
    </div>
</section>
<!-- teaser content end -->

<!--  Content wide start -->
<section class="content">

    <div class="one_third">
    <div class="widget_container">
        <h3>怎样的<span>流程</span></h3>
        <ul>
            <li>
                <img src="${ctxStatic }/mysite/images/creative_ideas.png" alt="img" class="thumb_img" />
                <div class="description">
                    <h4>创造性行业思维</h4>
                    <p>Phasellus tortor lectus, tincidunt eu vehicula ut, posuere Nulla facilisi etiam .</p>
                </div>
            </li>
            <li>
                <img src="${ctxStatic }/mysite/images/best_solutions.png" alt="img" class="thumb_img" />
                <div class="description">
                    <h4>最佳解决方案</h4>
                    <p>Maecenas sodales libero elit, et sagittis orci. Ut condimentum velit malesuada feugiat volutpat.</p>
                </div>
            </li>
            <li>
                <img src="${ctxStatic }/mysite/images/growth_strategies.png" alt="img" class="thumb_img" />
                <div class="description">
                    <h4>成长策略</h4>
                    <p>Nullam adipiscing varius diam, ut rhoncus orci congue a. Maecenas sollicitudin posuere at sapien.</p>
                </div>
            </li>
        </ul>
    </div>
    </div>
    
    <div class="one_third">
    <div class="widget_container">
        <h3>为什么 <span>选择我们</span></h3>
        <ul>
            <li>
                <img src="${ctxStatic }/mysite/images/icon_4.png" alt="img" class="thumb_img" />
                <div class="description">
                    <h4>清晰、现在代化设计</h4>
                    <p>Aenean sollicitudin, ligula eu placerat rhoncus, dui felis ornare magna, vel tempor sem nibh eu nulla.</p>
                </div>
            </li>
            <li>
                <img src="${ctxStatic }/mysite/images/icon_5.png" alt="img" class="thumb_img" />
                <div class="description">
                    <h4>24*7 服务支持</h4>
                    <p>Etiam faucibus bibendum lorem et vehicula. Suspendisse lacinia sem ac nulla tincidunt aliquam sed turpis.</p>
                </div>
            </li>
            <li>
                <img src="${ctxStatic }/mysite/images/icon_6.png" alt="img" class="thumb_img" />
                <div class="description">
                    <h4>SEO 搜索优化</h4>
                    <p>Fusce feugiat vestibulum augue, non egestas odio ornare varius. vitae ultricies ipsum euismod hendrerit.</p>
                </div>
            </li>
        </ul>
    </div>
    </div>
    
    <div class="one_third_last">
    <div class="widget_container">
        <h3>我们的 <span>专业领域</span></h3>
        <ul>
            <li>
            <img src="${ctxStatic }/mysite/images/icon_7.png" alt="img" class="thumb_img" />
            <div class="description">
                <h4>手机微购物</h4>
                <p>Morbi quis sem magna vitae venenatis felis Nam nec risus dui. Suspendisse potenti Vestibulum vitae magna.</p>
            </div>
            </li>
            <li>
            <img src="${ctxStatic }/mysite/images/icon_7.png" alt="img" class="thumb_img" />
            <div class="description">
                <h4>电子优惠券</h4>
                <p>Suspendisse feugiat vestibulum augue, non egestas odio ornare varius. vitae ultricies euismod vitae.</p>
            </div>
            </li>
            <li>
            <img src="${ctxStatic }/mysite/images/icon_7.png" alt="img" class="thumb_img" />
            <div class="description">
                <h4>电子名片</h4>
                <p>Potenti feugiat vestibulum augue, non egestas odio ornare varius. vitae ultricies ipsum euismod risus.</p>
            </div>
            </li>
        </ul>
    </div>
    </div>
    
</section>
<!--  Content wide end -->
</body>
</html>

