<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>下载优惠券</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="decorator" content="default" />
<meta name="description" content="Bianca Mobile Template">
<meta name="viewport"
	content="width=device-width initial-scale=1.0  maximum-scale=1.0">
	
</head>
<body>
	<table>
		<tr>
			<td>&nbsp;</td>
			<td><img src="${qrcodeImg }"/></td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td><button class="btn" onclick="location.href= "${qrcodeImg }" ></button> 下载</td>
			<td>&nbsp;</td>
		</tr>
	</table>
</body>
</html>
