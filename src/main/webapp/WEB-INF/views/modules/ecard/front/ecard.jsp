<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/head.jsp"%>

<html>
<head>
<title>${ecard.name}</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="decorator" content="default" />
<meta name="description" content="Bianca Mobile Template">
<meta name="viewport"
	content="width=device-width initial-scale=1.0  maximum-scale=1.0">

<link href="${ctxStatic}/ecard/p_blue/css/amazium.css" type="text/css" rel="stylesheet" />
<link href="${ctxStatic}/ecard/p_blue/css/base.css" type="text/css" rel="stylesheet" />

	<link rel="stylesheet" href="${ctxStatic}/ecard/p_blue/css/layout.css" />
    <link rel="stylesheet" href="${ctxStatic}/ecard/p_blue/css/fonts.css" />
    <link rel="stylesheet" href="${ctxStatic}/ecard/p_blue/css/prettyPhoto.css" />

</head>

<body>
	<header>
		<div class="row">
			<div class="row">
				<div class="grid_3">
					<h1>${ecard.name }</h1>
					<div id="photo">
						<img src="${url }" alt="我的照片" width="200" height="100" />
					</div>
				</div>
			</div>
		</div>
	</header>


	<div id="tab-container" class='tab-container'>
    
        <ul class='etabs'>
            <li class='tab'><a href="#home" class="home">首页</a></li>
            <li class='tab'><a href="#web" class="about">简介</a></li>
            <li class='tab'><a href="#contact" class="contact">联系方式</a></li>
        </ul>
        <div class="row">
        
        	<div class="grid_12">
            <div class='panel-container'>
              	<div id="home" class="page">
                    <h2><span>首页</span></h2>
                    <div class="content-wrap">
                    	<div class="row">
                            <div class="grid_6">
                            	<div class="grid_3">
							                    <div class="name-wrap">
							                        <h1>${ecard.name } 
							                        	<span>部门：${ecard.department }</span>
									                    <div class="contact-info"> <span class="phone-icon">电话：${ecard.mobile }</span> </div>
									                    <span ><a href="#">QQ:${ecard.qq }</a></span>
									                    <span ><a href="#">EMail:${ecard.mail }s</a></span>
							                        </h1>
							                    </div>
							                </div>
                            
                            </div>
                            <h3>个人简介</h3>
                            <div class="grid_6">
                                <div class="content-pad">
                                <div class="list_carousel responsive about">
                                        	${ecard.description}
                                </div>	
                            </div>
                            
                            
                        </div>
                        <div class="clearfix">&nbsp;</div>
                    </div>
                </div>
                <hr/>
                <div id="web" class="page">
                    <h2><span>单位</span></h2>
                    <div class="content-wrap">
                    	<div class="row">
                    	<div class="grid_4">
	                    	<ul >
	                    		<li>单位名称：<span>${ecard.organInfo.name}</span> </li>
	                    		<li>联系电话：<span>${ecard.organInfo.tel}</span></li>
	                    		<li>单位地址：<span>${ecard.organInfo.address}</span></li>
	                    		<li>单位网址：<span>${ecard.organInfo.site}</span></li>
	                    	</ul>
	                    	</div>
                    	</div>
                    	<div class="row">
                            <div class="grid_4">
                                <div class="content-pad">
                                	<h3>活动</h3>
                                	<ul class="my-skills">
											<c:forEach items="${ecard.organInfo.organEvents }"
												var="event">
												<li>${event.title } <span>1</span><span>1</span><span>1</span><span>1</span><span>1</span></li>
											</c:forEach>
                                    </ul>
                                </div>	
                            </div>
                        </div>
                        <div class="clearfix">&nbsp;</div>                      
                    </div>
                </div>
             
             </div>
    	</div>
    </div>
	</div>
    <footer>
    	<div class="row">
            <div class="grid_6">
            </div>
        </div>
    	<div class="bottom-line">&nbsp;</div>
    </footer>
    
    <p id="back-top" style="display: block;">
        <a href="#top">&nbsp;</a>
    </p>
</body>
</html>