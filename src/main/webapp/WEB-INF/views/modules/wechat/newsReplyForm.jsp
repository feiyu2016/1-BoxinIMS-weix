<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>


<html>
<head>
	<title>图文富内容回复管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript" src="${ctxStatic}/bootstrap/2.3.1/docs/assets/js/bootstrap-popover.js"></script>
	<script type="text/javascript" src="${ctxStatic}/bootstrap/2.3.1/docs/assets/js/bootstrap-tooltip.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
		
		function showTip(id){
			
			var flag = $('#'+id).css('display');
			if('none' === flag){
				$('#'+id).show();
			}else{
				$('#'+id).hide();
			}
		}
		
		
		
		function hideTip(id){
			 $('#'+id).hide();
		}
		
		function  setUrl(url){
			$('#url').value(url);
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/wechat/newsReply/">图文回复列表</a></li>
		<li class="active"><a href="${ctx}/wechat/newsReply/form?id=${newsReply.id}">图文回复</a></li>
		<li><a href="${ctx}/wechat/config/form">文字回复</a></li>
	</ul><br/>
	
	<c:if test="${addFlag } eq(false)">
		<div class="alert alert-block alert-error fade in">
            <button type="button" class="close" data-dismiss="alert">×</button>
            <h4 class="alert-heading">用户发送的内容</h4>
            <p>设定好用户要咨询的关键词,根据关键词回复设定的消息内容。</p>
            <p>
              <a class="btn btn-danger" href="#">Take this action</a> <a class="btn" href="#">Or do this</a>
            </p>
          </div>
	</c:if>
	
	<form:form id="inputForm" modelAttribute="newsReply" action="${ctx}/wechat/newsReply/save" method="post" class="form-horizontal"  enctype="multipart/form-data">
		<form:hidden path="id"/>
		<form:hidden path="filePath"/>
		<form:hidden path="weChat.id"/>
		<form:hidden path="wechatConfig.id"/>
		<form:hidden path="wechatConfig.weChat.id"/>
		<tags:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">关键词:</label>
			<div class="controls">
				<form:input path="wechatConfig.upContent" htmlEscape="false"  maxlength="11" class="required"
				data-toggle="tooltip" data-placement="top" title="" data-original-title="Tooltip on top"/> 
				&nbsp; <a href="#" onclick="showTip('question')"><img src="${ctxStatic}/images/question.png"></img></a>
				<div class="alert alert-block alert-error fade in" id="question" style="display:none;margin-top:5px;" onclick="hideTip('question')">
		            <button type="button" class="close"  onclick="hideTip('question')" >×</button>
		            <h4 class="alert-heading">用户发送的关键词</h4>
		            <p>设定好用户预咨询的关键词,并对此关键词回复设定的图文消息内容.</p>
    			</div>
			</div>
			
		</div>
		<div class="control-group">
			<label class="control-label">图片标题:</label>
			<div class="controls">
				<form:input path="title" htmlEscape="false" maxlength="50"   class="required"/>
				&nbsp;<a href="#" onclick="showTip('pic_title')"><img src="${ctxStatic}/images/question.png"></img></a>
				<div class="alert alert-block alert-error fade in" id="pic_title" style="display:none;margin-top:5px;"  onclick="hideTip('pic_title')">
		            <button type="button" class="close"  onclick="hideTip('pic_title')" >×</button>
		            <h4 class="alert-heading">返回的图片标题</h4>
		            <p>这里设置的标题将会显示在微信中的图片的标题,如下图：</p>
		            <p>
		                 <img alt="图片标题" src="${ctxStatic }/images/weixin_items_title.png">
		            </p>
    			</div>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">图片描述:</label>
			<div class="controls">
				<form:textarea path="description" htmlEscape="false" cols="10" rows="6"   class="required"
					data-toggle="popover" data-placement="right" data-content="Vivamus sagittis lacus vel augue laoreet rutrum faucibus." title="" data-original-title="Popover on right"
				/>
				
				&nbsp;<a href="#" onclick="showTip('pic_desc')"><img src="${ctxStatic}/images/question.png"></img></a>
				<div class="alert alert-block alert-error fade in" id="pic_desc" style="display:none;margin-top:5px;" onclick="hideTip('pic_desc')">
		            <button type="button" class="close"  onclick="hideTip('pic_desc')" >×</button>
		            <h4 class="alert-heading">图片描述</h4>
		            <p>这里设置的描述内容将会显示在微信中的图片下方的描述中，如下图：</p>
		            <p>
		                 <img alt="描述图" src="${ctxStatic}/images/weixin_tile_desc.jpg">
		            </p>
    			</div>
				
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">上传图片:</label>
			<div class="controls">
				<c:if test="${newsReply.filePath ne '' }">
					<div class="control"><img src="${newsReply.picUrl }" style="width:300px;height:100px"/></div>
				</c:if>
				<div class="control">
					<input type="file" name="file" htmlEscape="false"   />    <span class="alert">大图片建议尺寸：720像素 * 400像素;  小图片建议尺寸：400像素 * 400像素 </span>      
				</div>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">原文链接:</label>
			<div class="controls">
				<form:input path="url"  id="url" htmlEscape="false"   />  &nbsp;<span class="alert">链接必须以 http://开头</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">链接二维码图片:</label>
			<div class="controls">
				<input type="file" name="qrfile" htmlEscape="false"    onchange="setUrl(this.value)"/> &nbsp;<span class="alert">二维码的内容是以 http://开头的链接地址.</span>
			</div>
		</div>
		
		<div class="form-actions">
			<shiro:hasPermission name="wechat:newsReply:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>

	<div class="popover fade right in" 
		style="top: 12.5px; left: 242px; display: none;" id="question_tip">
		<div class="arrow"></div>
		<h3 class="popover-title">关键词</h3>
		<div class="popover-content">在此处请输入自动回复的关键词。</div>
	</div>
	
	
	
	
	
</body>
</html>
