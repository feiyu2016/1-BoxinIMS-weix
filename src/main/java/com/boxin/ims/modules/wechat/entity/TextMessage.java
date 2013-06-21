package com.boxin.ims.modules.wechat.entity;

import java.util.Map;

/**
 * 
 * @author Jakemanse
 * @date 2013-6-19
 * @function <p> 
 * 
 * 	<xml>
		 <ToUserName><![CDATA[toUser]]></ToUserName>
		 <FromUserName><![CDATA[fromUser]]></FromUserName> 
		 <CreateTime>1348831860</CreateTime>
		 <MsgType><![CDATA[text]]></MsgType>
		 <Content><![CDATA[this is a test]]></Content>
		 <MsgId>1234567890123456</MsgId>
 	</xml>
 * 
 * </p>
 */

public class TextMessage extends Message{
	
	public final static String MSG_TYPE = "text";
	
	public TextMessage() {
		this.MsgType = "text";
	}

	public TextMessage(Map<String,String> textMap){
		this.setContent(textMap.get("xml.Content"));
		this.setMsgType("text");
		this.setFromUserName(textMap.get("xml.ToUserName"));
		this.setToUserName(textMap.get("xml.FromUserName"));
		this.setCreateTime(textMap.get("xml.CreateTime"));
	}
	
	
	@Override
	public String getMsgType() {
		return "text";
	}
	
	
	@Override
	public String toString() {
		StringBuffer sb  = new StringBuffer();
		sb.append("<xml>");
		sb.append("\t").append("<ToUserName><![CDATA["+this.getToUserName()+"]]></ToUserName>").append("\n");
		sb.append("\t").append("<FromUserName><![CDATA["+this.getFromUserName()+"]]></FromUserName>").append("\n");
		sb.append("\t").append("<CreateTime>"+System.currentTimeMillis()+"</CreateTime>").append("\n");
		sb.append("\t").append("<Content><![CDATA["+this.getContent()+"]]></Content>").append("\n");
		sb.append("\t").append("<MsgType><![CDATA[text]]></MsgType>").append("\n");
		sb.append("\t").append("<FuncFlag>0</FuncFlag>").append("\n");
		sb.append("</xml>");
		
		return sb.toString();
	}

	/**
	 * 回复信息
	 */
	@Override
	public String replyMessage() {
		StringBuffer sb  = new StringBuffer();
		sb.append("<xml>");
		sb.append("\t").append("<ToUserName><![CDATA["+this.getToUserName()+"]]></ToUserName>").append("\n");
		sb.append("\t").append("<FromUserName><![CDATA["+this.getFromUserName()+"]]></FromUserName>").append("\n");
		sb.append("\t").append("<CreateTime>"+System.currentTimeMillis()+"</CreateTime>").append("\n");
		sb.append("\t").append("<Content><![CDATA["+this.getContent()+"]]></Content>").append("\n");
		sb.append("\t").append("<MsgType><![CDATA["+this.getMsgType()+"]]></MsgType>").append("\n");
		sb.append("\t").append("<FuncFlag>0</FuncFlag>").append("\n");
		sb.append("</xml>");
		
		return sb.toString();
	}
	

}
