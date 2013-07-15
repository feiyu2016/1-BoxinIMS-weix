<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<meta name="decorator" content="default"/>
		<%@include file="/WEB-INF/views/include/dialog.jsp" %>
	  <script type="text/javascript">
  	function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").attr("action","${ctx}/product/formClassify");
			$("#searchForm").submit();
	    	return false;
	 }
			function search(){
				$("#searchForm").attr("action","${ctx}/product/formClassify");
				$("#searchForm").submit();
			}
			
			function btnUpdate(obj){
				
			}
			function btnDel(obj){}
  </script>	
  </head>

  <body>
     <ul class="nav nav-tabs">
    	<li ><a href="${ctx}/product/formItem">产品项</a></li>
    	<li class="active"> <a href="${ctx}/product/formClassify">产品类型</a></li>
    </ul>
    <form:form id="searchForm" modelAttribute="classify" action="${ctx}/product/saveClassify" method="post" class="form-horizontal" >
    	<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<form:hidden path="id"/>
    	<div class="control-group">
    		<label class="control-label">名称:</label>
				<div class="controls">
					<form:input path="name" htmlEscape="false" maxlength="11" class="required"/>
					<input id="btnCancel" class="btn" type="button" value="查询" onclick="search()"/>
					<shiro:hasPermission name="ims:product:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>					
				</div>
    	</div>
    	<div class="control-group">
    		<label class="control-label">描述:</label>
				<div class="controls">	
					<form:textarea path="desc" htmlEscape="false"  class="required"/>			
				</div>
    	</div>
    </form:form>
    <tags:message content="${message}"/>
	<table id="treeTable" style="width:80%" class="table table-striped table-bordered ">
		<thead>
			<tr>
				<th>名称</th>
				<th>描述</th>
				<th>创建时间</th>
				<shiro:hasPermission name="ims:product:edit">
					<th>操作</th>
				</shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="classify">
				<tr>
					<td style="width: 200px">${classify.name}</td>
					<td style="width: 400px">${classify.desc}</td>
					<td style="width: 300px"><fmt:formatDate value="${classify.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
					<shiro:hasPermission name="ims:product:edit">
						<td>
							<span class="btn-group">							   
							    <a href="${ctx}/product/formClassify?id=${classify.id}" data-item="${classify.id}" id="btn-${classify.id}-update" class="btn btn-small" onclick="btnUpdate(this.id)"><i class="icon-pencil"></i></a>
							    <a href="${ctx}/product/deleteClassify?id=${classify.id}"  id="btn-${classify.id}-del" class="btn btn-small" onclick="btnDel(this)"><i class="icon-trash"></i></a>
							</span>
						</td>
					</shiro:hasPermission>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
  </body>

</html>
