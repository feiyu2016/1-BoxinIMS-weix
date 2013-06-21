package com.boxin.ims.modules.wechat.entity;

public abstract class Message {
	protected String ToUserName;
	protected String FromUserName;
	protected String CreateTime;
	protected String MsgType;
	protected String MsgId;
	protected String Content;
	protected String FuncFlag;
	
	
	
	
	public abstract String  getMsgType();
	public abstract String  replyMessage();




	public String getToUserName() {
		return ToUserName;
	}




	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}




	public String getFromUserName() {
		return FromUserName;
	}




	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}




	public String getCreateTime() {
		return CreateTime;
	}




	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}




	public String getContent() {
		return Content;
	}




	public void setContent(String content) {
		Content = content;
	}




	public String getFuncFlag() {
		return FuncFlag;
	}




	public void setFuncFlag(String funcFlag) {
		FuncFlag = funcFlag;
	}




	public void setMsgType(String msgType) {
		MsgType = msgType;
	}




	public String getMsgId() {
		return MsgId;
	}




	public void setMsgId(String msgId) {
		MsgId = msgId;
	}
	
	
	
	

}
