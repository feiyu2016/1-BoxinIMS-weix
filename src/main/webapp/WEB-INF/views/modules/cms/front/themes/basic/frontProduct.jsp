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
	
	<script type="text/javascript">
	jQuery(document).ready(function() {
		jQuery("a.example6").fancybox({
			'titlePosition'		: 'outside',
			'overlayColor'		: '#000',
			'overlayOpacity'	: 0.9
		});
	});
	</script>
</head>
<body>
<!--  Content wide start -->
<section class="content">

<hr>

<!--  Pricing table start -->
<section id="pricing_table">
<div class="one_third">
    <div class="heading pricing_col_1">
        <h3><strong>电子优惠券</strong></h3>
        <h2><strong></strong></h2>
        <span><i></i></span>
    </div>
    <ul>
        <li>在线获取</li>
        <li>电子凭证</li>
        <li>系统核销</li>
        <li>用户数据收集管理</li>
        <li>数据统计分析</li>
    </ul>
    <div class="price_button">
        <a href="${ctx}/view-41-97.html" class="read_more">详细信息</a>
    </div>
</div>

<div class="one_third highlight">
    <div class="heading wide pricing_col_2">
        <h3><strong>移动营销</strong></h3>
        <h2><strong></strong></h2>
        <span><i></i></span>
    </div>
    <ul>
        <li><strong>自定义</strong> 手机版网站</li>
        <li><strong>个性化</strong> 网站导航</li>
        <li><strong>地址</strong>地图精确定位</li>
        <li><strong>在线报名</strong> 活动</li>
        <li>在线抽奖</li>
        <li>数据分析</li>
    </ul>
    <div class="price_button">
        <a href="${ctx}/view-41-97.html" class="read_more">详细信息</a>
    </div>
</div>

<div class="one_third">
    <div class="heading pricing_col_3">
        <h3><strong>电子会员卡</strong></h3>
        <h2><strong></strong></h2>
        <span><i></i></span>
    </div>
    <ul>
        <li>传统会员卡的<strong>革命</strong></li>
        <li><strong>不用随身携带</strong>，存储在手机中</li>
        <li><strong>无须记忆</strong>， 打开微信或彩信即可使用</li>
        <li>微信会员卡，更方便，更简洁</li>
        <li>自动余额查询、积分查询</li>
    </ul>
    <div class="price_button">
        <a href="${ctx}/view-41-110.html" class="read_more">详细信息</a>
    </div>
</div>

<div class="clear"></div>
<div class="pricing_space"></div>

<div class="one_fourth">
    <div class="heading pricing_col_1">
        <h3><strong>电子名片</strong></h3>
        <h2><strong></strong></h2>
        <span><i></i></span>
    </div>
    <ul>
        <li>丰富的<strong>基础信息和公司信息</strong></li>
        <li>公司的思念及产品信息</li>
        <li>主要客户及业务范围介绍</li>
        <li>音频、视频宣传</li>
        <li>联系方式一键保存至手机</li>
        <li>个人像册</li>
    </ul>
    <div class="price_button">
        <a href="${ctx}/view-41-112.html" class="read_more">详细信息</a>
    </div>
</div>
<div class="one_fourth highlight">
    <div class="heading wide pricing_col_2">
        <h3><strong>电子点餐</strong></h3>
        <h2><strong></strong></h2>
        <span><i></i></span>
    </div>
    <ul>
        <li>经营大规模菜系时单据多、信息量大</li>
        <li>分单、传菜等环节越多越易出差错，影响服务质量和效率。</li>
        <li>通过点餐系统操作，按照点餐时间等级排序</li>
        <li>手机扫码，进入到菜谱进行点餐系统，共同点餐。</li>
        <li>进入后台管理系统，操作一目了然，业务流程清晰明了，操作简单。</li>
        <li>一桌一单，灵活管理，简化业务流程。</li>
    </ul>
    <div class="price_button">
        <a href="${ctx}/view-41-113.html" class="read_more">详细信息</a>
    </div>
</div>
<div class="one_fourth">
    <div class="heading pricing_col_3">
        <h3><strong>电子票凭证</strong></h3>
        <h2><strong></strong></h2>
        <span><i></i></span>
    </div>
    <ul>
        <li>节约成本</li>
        <li>用户感受度好</li>
        <li>数据安全</li>
        <li>准确的业务统计数据</li>
        <li>节省时间，提高效率</li>
        <li>二维码电子票据，扫描使用方便</li>
    </ul>
    <div class="price_button">
        <a href="${ctx}/view-41-115.html" class="read_more">详细信息</a>
    </div>
</div>
<div class="one_fourth">
    <div class="heading pricing_col_4">
        <h3><strong>防伪溯源</strong></h3>
        <h2><strong></strong></h2>
        <span><i></i></span>
    </div>
    <ul>
        <li>与ERP结合</li>
        <li>仓储系统支持</li>
        <li>产品管理</li>
        <li>产品追溯系统支持 </li>
        <li>数据统计分析</li>
        <li>成本低廉</li>
    </ul>
    <div class="price_button">
        <a href="${ctx}/view-41-116.html" class="read_more">详细信息</a>
    </div>
</div>

</section>
<!--  Pricing table END -->


</section>
<!--  Content wide end -->

</body>
</html>
