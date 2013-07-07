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
                <h2>Its a <span>Responsive</span> Template</h2>
                <h3>Fusce lobortis egestas risus tincidunt facilisis.</h3>
            </div>
        </li>
        <li> 
            <img src="${ctxStatic }/mysite/images/slider_img_2.png" alt="img" />
            <div class="ei-title">
                <h2>Globex is <span>Easy</span> to <span>Customize</span> </h2>
                <h3>In hac habitasse platea dictumst. Donec non consequat justo. </h3>
            </div>
        </li>
        <li>  
            <img src="${ctxStatic }/mysite/images/slider_img_3.png" alt="img" />
            <div class="ei-title">
                <h2><span>Solution</span> that <span>you</span> need!</h2>
                <h3>Sed mollis felis vitae metus euismod feugiat ac a arcu.</h3>
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
    
        <h3>Best <span>Services</span></h3>
        Duis dignissim blandit varius. Curabitur adipiscing ornare luctus. 
        Vestibulum venenatis sagittis turpis, eu varius enim vulputate pretium. 
        Sed eget leo sed diam aliquam interdum ut auctor erat. Suspendisse vitae 
        velit leo, et pulvinar velit.
        <span class="teaser_icon">
        <img src="${ctxStatic }/mysite/images/paper_plane.png" alt="img" />
        </span>
    </div>
    <div class="one_third">
        <h3>Quick <span>Support</span></h3>
        Interdum dignissim blandit varius. Curabitur adipiscing ornare luctus. 
        Vestibulum venenatis sagittis turpis, eu varius enim vulputate pretium. 
        Sed eget leo sed diam aliquam interdum ut auctor erat. Suspendisse vitae 
        velit leo, et pulvinar leo.
        <span class="teaser_icon">
        <img src="${ctxStatic }/mysite/images/wheel.png" alt="img" />
        </span>
    </div>
    <div class="one_third_last">
        <h3>Global <span>Solutions</span></h3>
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
        <h3>How It <span>Works</span></h3>
        <ul>
            <li>
                <img src="${ctxStatic }/mysite/images/creative_ideas.png" alt="img" class="thumb_img" />
                <div class="description">
                    <h4>Creative Ideas</h4>
                    <p>Phasellus tortor lectus, tincidunt eu vehicula ut, posuere Nulla facilisi etiam .</p>
                </div>
            </li>
            <li>
                <img src="${ctxStatic }/mysite/images/best_solutions.png" alt="img" class="thumb_img" />
                <div class="description">
                    <h4>Best Solutions</h4>
                    <p>Maecenas sodales libero elit, et sagittis orci. Ut condimentum velit malesuada feugiat volutpat.</p>
                </div>
            </li>
            <li>
                <img src="${ctxStatic }/mysite/images/growth_strategies.png" alt="img" class="thumb_img" />
                <div class="description">
                    <h4>Growth Stratgies</h4>
                    <p>Nullam adipiscing varius diam, ut rhoncus orci congue a. Maecenas sollicitudin posuere at sapien.</p>
                </div>
            </li>
        </ul>
    </div>
    </div>
    
    <div class="one_third">
    <div class="widget_container">
        <h3>Why <span>Choose Us</span></h3>
        <ul>
            <li>
                <img src="${ctxStatic }/mysite/images/icon_4.png" alt="img" class="thumb_img" />
                <div class="description">
                    <h4>Clean and modern design</h4>
                    <p>Aenean sollicitudin, ligula eu placerat rhoncus, dui felis ornare magna, vel tempor sem nibh eu nulla.</p>
                </div>
            </li>
            <li>
                <img src="${ctxStatic }/mysite/images/icon_5.png" alt="img" class="thumb_img" />
                <div class="description">
                    <h4>24/7 Support</h4>
                    <p>Etiam faucibus bibendum lorem et vehicula. Suspendisse lacinia sem ac nulla tincidunt aliquam sed turpis.</p>
                </div>
            </li>
            <li>
                <img src="${ctxStatic }/mysite/images/icon_6.png" alt="img" class="thumb_img" />
                <div class="description">
                    <h4>SEO Optimized</h4>
                    <p>Fusce feugiat vestibulum augue, non egestas odio ornare varius. vitae ultricies ipsum euismod hendrerit.</p>
                </div>
            </li>
        </ul>
    </div>
    </div>
    
    <div class="one_third_last">
    <div class="widget_container">
        <h3>Our <span>Priority</span></h3>
        <ul>
            <li>
            <img src="${ctxStatic }/mysite/images/icon_7.png" alt="img" class="thumb_img" />
            <div class="description">
                <h4>Fusce lobortis egestas</h4>
                <p>Morbi quis sem magna vitae venenatis felis Nam nec risus dui. Suspendisse potenti Vestibulum vitae magna.</p>
            </div>
            </li>
            <li>
            <img src="${ctxStatic }/mysite/images/icon_7.png" alt="img" class="thumb_img" />
            <div class="description">
                <h4>Risus tincidunt facilisis</h4>
                <p>Suspendisse feugiat vestibulum augue, non egestas odio ornare varius. vitae ultricies euismod vitae.</p>
            </div>
            </li>
            <li>
            <img src="${ctxStatic }/mysite/images/icon_7.png" alt="img" class="thumb_img" />
            <div class="description">
                <h4>Donec non consequat justo</h4>
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

