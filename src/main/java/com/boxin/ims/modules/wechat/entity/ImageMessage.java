package com.boxin.ims.modules.wechat.entity;

import java.util.Map;

public class ImageMessage extends Message {
	
	public final static String MSG_TYPE = "image";
	private String PicUrl;

	public ImageMessage() {
		// TODO Auto-generated constructor stub
	}
	
	public ImageMessage(Map<String,String> textMap) {
		this.setContent(textMap.get("xml.Content"));
		this.setMsgType("text");
		this.setFromUserName(textMap.get("xml.ToUserName"));
		this.setToUserName(textMap.get("xml.FromUserName"));
		this.setCreateTime(textMap.get("xml.CreateTime"));
	}
	
	
	
	@Override
	public String getMsgType() {
		return "image";
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	
	

	@Override
	public String replyMessage() {
		StringBuffer sb  = new StringBuffer();
		sb.append("<xml>");
		sb.append("\t").append("<ToUserName><![CDATA["+this.getToUserName()+"]]></ToUserName>").append("\n");
		sb.append("\t").append("<FromUserName><![CDATA["+this.getFromUserName()+"]]></FromUserName>").append("\n");
		sb.append("\t").append("<CreateTime>"+System.currentTimeMillis()+"</CreateTime>").append("\n");
		sb.append("\t").append("<Content><![CDATA["+this.getContent()+"]]></Content>").append("\n");
		sb.append("\t").append("<MsgType><![CDATA["+getMsgType()+"]]></MsgType>").append("\n");
		sb.append("\t").append("<FuncFlag>0</FuncFlag>").append("\n");
		sb.append("</xml>");
		
		return sb.toString();
	}

	
	
}
