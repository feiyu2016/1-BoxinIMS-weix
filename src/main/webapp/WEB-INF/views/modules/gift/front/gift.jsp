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


	<audio  controls="controls"  autoplay="autoplay"> 
		<source src="${ctxStatic }/flash/gift_2_1374948782743.mp3" type="audio/mpeg" />
	</audio>
	
	<audio controls="controls" autoplay="autoplay">
  <source src="${ctxStatic }/flash/gift_2_1374948782743.mp3" type="audio/mpeg" />
  <source src="/i/song.ogg" type="audio/ogg" />
Your browser does not support the audio element.
</audio>
</body>
</html>