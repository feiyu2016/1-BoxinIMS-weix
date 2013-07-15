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
                <h2><span></span></h2>
                <h3></h3>
                <h3></h3>
            </div>
        </li>
        <li> 
            <img src="${ctxStatic }/mysite/images/slider_img_2.png" alt="img" />
            <div class="ei-title">
                <h2> <span></span> <span></span> </h2>
                <h3> </h3>
                <h3> </h3>
            </div>
        </li>
        <li>  
            <img src="${ctxStatic }/mysite/images/slider_img_3.png" alt="img" />
            <div class="ei-title">
                <h2><span></span> <span></span></h2>
                <h3></h3>
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
        <h3>我们<span>最便宜</span></h3>
        <ul>
            <li>
                <img src="${ctxStatic }/mysite/images/creative_ideas.png" alt="img" class="thumb_img" />
                <div class="description">
                    <h4>电子名片</h4>
                    <p>现在起你的名片不只是只有你的基本信息了，还可以有声音、图片、视频、公司活动等信息了</p>
                </div>
            </li>
            
            <li>
                <img src="${ctxStatic }/mysite/images/best_solutions.png" alt="img" class="thumb_img" />
                <div class="description">
                    <h4>电子会员卡</h4>
                    <p>还用普通会员卡你Out了，从现在开始你可享受高科技电子会员卡，电子会员卡与你的手机融为 一体,再不用担心忘记带在身上.</p>
                </div>
            </li>
            <li>
                <img src="${ctxStatic }/mysite/images/growth_strategies.png" alt="img" class="thumb_img" />
                <div class="description">
                    <h4>电子点餐系统</h4>
                    <p>还为服务员忙不过来而烦心，还为客人多了招呼不过来而苦恼? 电子点餐系统为您提供最方便高效的服务功能，降低您的投入成本，提高您的经营效益.</p>
                </div>
            </li>
        </ul>
    </div>
    </div>
    
    <div class="one_third">
    <div class="widget_container">
        <h3>我们<span>最专业</span></h3>
        <ul>
            <li>
                <img src="${ctxStatic }/mysite/images/icon_4.png" alt="img" class="thumb_img" />
                <div class="description">
                    <h4>通用电子票核销管理</h4>
                    <p>为商家解决商户管理、商品管理、订单管理、消费管理、终端管理、凭证管理、帐单管理、凭证核销。</p>
                </div>
            </li>
            <li>
                <img src="${ctxStatic }/mysite/images/icon_5.png" alt="img" class="thumb_img" />
                <div class="description">
                    <h4>淘宝电子票核销管理</h4>
                    <p>为淘宝商家提供非常完善的核销管理平台，方便商家维护和分析管理客户，及非常完善的数据服务和更多更开放的模式。</p>
                </div>
            </li>
            <li>
                <img src="${ctxStatic }/mysite/images/icon_6.png" alt="img" class="thumb_img" />
                <div class="description">
                    <h4>电子优惠券</h4>
                    <p>为合作商家提供电子优惠劵的发放与统计管理，商家可以自行设定优惠劵的内容以及各种属性，方便商家的管理与操作.</p>
                </div>
            </li>
        </ul>
    </div>
    </div>
    
    <div class="one_third_last">
    <div class="widget_container">
        <h3>我们<span>最优秀</span></h3>
        <ul>
        	  <li>
            <img src="${ctxStatic }/mysite/images/icon_7.png" alt="img" class="thumb_img" />
            <div class="description">
                <h4><span>移动营销</span>  </h4>
                <p>为企业提供二维码发布、平台展示、数据分析、个性服务、整合营销等一系列的相关管理，并且具有电子优惠劵的所有功能.</p>
            </div>
            </li>
            <li>
            <img src="${ctxStatic }/mysite/images/icon_7.png" alt="img" class="thumb_img" />
            <div class="description">
                <h4>手机微购物</h4>
                <p>为您的产品提供最方便的营销渠道，减少广告投入，增加利润附加值，利用最新电子凭证科技核销手段实现高效经营管理.</p>
            </div>
            </li>
          
            <li>
            <img src="${ctxStatic }/mysite/images/icon_7.png" alt="img" class="thumb_img" />
            <div class="description">
                <h4>防伪溯源</h4>
                <p>为产品建立一套产品信息化管理系统，每个产品拥有一个可追溯的二维码.</p>
            </div>
            </li>
        </ul>
    </div>
    </div>
    
</section>
<!--  Content wide end -->
</body>
</html>

