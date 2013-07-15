<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的产品</title>
<meta name="decorator" content="default"/>
	<%@include file="/WEB-INF/views/include/dialog.jsp" %>
	<style type="text/css">.sort{color:#0663A2;cursor:pointer;}</style>
	<script type="text/javascript">
		var itemId;
		$(document).ready(function() {
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").attr("action","${ctx}/product");
			$("#searchForm").submit();
	    	return false;
	    }
	   function btnUpdate(id){
			itemId = id;
		}
	
		function btnDel(obj){
			itemId = id;
		}
	</script>
</head>
<body>
	<form:form id="searchForm" modelAttribute="productModel" action="${ctx}/sys/user/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<input id="orderBy" name="orderBy" type="hidden" value="${page.orderBy}"/>

		<div>
			<label>产品类型：</label>
			<form:select path="productType" id="productType" >
				<form:option value="0" label="--请选择--"/>
				<form:options items="${classify}" itemValue="id" itemLabel="name"/>
			</form:select>
			<label>产品名称：</label><form:input path="productName" htmlEscape="false" maxlength="50" class="input-medium"/>
			&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询" onclick="page()"/>
		</div>
	</form:form>
	<tags:message content="${message}"/>
	<table id="treeTable" class="table table-striped table-bordered ">
		<thead>
			<tr>
				<th>名称</th>
				<th>短名称</th>
				<th>产品类型</th>
				<th>序列号</th>
				<th>是否发布</th>				
				<th>价格</th>
				<th>优惠价格</th>
				<th>创建时间</th>
				<shiro:hasPermission name="ims:product:edit">
					<th>操作</th>
				</shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="item">
				<tr>
					<td>${item.name}</td>
					<td>${item.shortName}</td>
					<td><span style="color:blue">${item.type.name}</span></td>
					<td>${item.serialNumber}</td>
					<td><c:if test="${item.publish== true}" var="x">是</c:if><c:if test="${item.publish == false}" var="x">否</c:if> </td>					
					<td class="sort price">${item.price}</td>
					<td class="sort preferentialPrice">${item.preferentialPrice}</td>
					<td class="sort createTime"><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
					<shiro:hasPermission name="ims:product:edit">
						<td>
							<span class="btn-group">
							    <a href="#" data-item="${item.id}" id="btn-${item.id}-search" class="btn btn-small" onclick="btnSearch(this)"><i class="icon-search"></i></a>
							    <a href="#" data-item="${item.id}" id="btn-${item.id}-update" class="btn btn-small" onclick="btnUpdate(this.id)"><i class="icon-pencil"></i></a>
							    <a href="#" data-item="${item.id}" id="btn-${item.id}-del" class="btn btn-small" onclick="btnDel(this)"><i class="icon-trash"></i></a>
							</span>
						</td>
					</shiro:hasPermission>
				</tr>
			</c:forEach>
		</tbody>
		
	</table>
	<div class="pagination">${page}</div>
</body>

<script type="text/javascript">
		
</script>
</html>