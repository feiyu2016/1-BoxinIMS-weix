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
			<td><a class="btn" href="${qrcodeImg }&action=d&fn=${coupon.number }" >保存</a> </td>
			<td>&nbsp;</td>
		</tr>
	</table>
</body>
</html>
