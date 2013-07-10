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
        <li>  
            <img src="${ctxStatic }/mysite/images/slider_img_4.jpg" alt="img" />
            <div class="ei-title">
            </div>
        </li>
    </ul>
    <ul class="ei-slider-thumbs">
        <li class="ei-slider-element">Current</li>
        <li><a href="#">Slide 1</a></li>
        <li><a href="#">Slide 2</a></li>
        <li><a href="#">Slide 3</a></li>
        <li><a href="#">Slide 4</a></li>
    </ul>
</div>
<div class="clear"></div>
<!-- Elastic Slider end -->



<!-- teaser content start -->
<section class="teaser">
    <div class="one_third">
    
        <h3>营销过程 <span>管理优化</span></h3>
        在移动互联网时代，企业无法容易有效的低成本的实现现场管控，云媒体营销平台—“过程管理、分段治事”，迅速帮企业将繁琐的常态互动营销进行快速优化， 通过二维码形式优化营销管理过程，提升客户服务质量，降低管理成本。.
        <span class="teaser_icon">
        <img src="${ctxStatic }/mysite/images/paper_plane.png" alt="img" />
        </span>
    </div>
    <div class="one_third_last">
        <h3>效果数据 <span>量化分析</span></h3>
        通过互动营销活动快速收集顾客的来源，关注点，反馈意见，使用体验信息，实现对营销过程中的渠道效果、兴趣所向，时间分布、客户满意度等方面多纬度多角度进行精准的数据统计以及详尽的数据分析，从而实现营销效果的量化以及商业机会的挖掘。
        <span class="teaser_icon">
        <img src="${ctxStatic }/mysite/images/chart.png" alt="img" />
        </span>
    </div>
    <div class="one_third">
        <h3>互动营销 <span>效果增强</span></h3>
        盘活、整合、优化传统媒介资源，带动线上线下互动营销，又能丰富微信、微博互动营销的形式，增强营销的效果；帮助广大传统企业将通过智能手机这个重要媒介将大量的客户群进行线上线下的互为转化，让企业赢在移动互联网时代的起跑线上。
        <span class="teaser_icon">
        <img src="${ctxStatic }/mysite/images/wheel.png" alt="img" />
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

