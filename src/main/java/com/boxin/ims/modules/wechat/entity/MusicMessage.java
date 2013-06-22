package com.boxin.ims.modules.wechat.entity;

import java.util.Map;

public class MusicMessage extends Message{

	
	public final static String MSG_TYPE = "music";
	private String Title;
	private String Description;
	private String MusicUrl;
	private String HQMusicUrl;
	
	public MusicMessage(Map<String,String> textMap){
		this.setContent(textMap.get("xml.Content"));
		this.setMsgType("text");
		this.setFromUserName(textMap.get("xml.ToUserName"));
		this.setToUserName(textMap.get("xml.FromUserName"));
		this.setCreateTime(textMap.get("xml.CreateTime"));
	}
	
	
	@Override
	public String getMsgType() {
		return MSG_TYPE;
	}

	/**
	 * <xml>
		 <ToUserName><![CDATA[toUser]]></ToUserName>
		 <FromUserName><![CDATA[fromUser]]></FromUserName>
		 <CreateTime>12345678</CreateTime>
		 <MsgType><![CDATA[music]]></MsgType>
		 <Music>
		 <Title><![CDATA[TITLE]]></Title>
		 <Description><![CDATA[DESCRIPTION]]></Description>
		 <MusicUrl><![CDATA[MUSIC_Url]]></MusicUrl>
		 <HQMusicUrl><![CDATA[HQ_MUSIC_Url]]></HQMusicUrl>
		 </Music>
		 <FuncFlag>0</FuncFlag>
		</xml>
	 */
	@Override
	public String replyMessage() {
		StringBuffer sb  = new StringBuffer();
		sb.append("<xml>");
		sb.append("\t").append("<ToUserName><![CDATA["+this.getToUserName()+"]]></ToUserName>").append("\n");
		sb.append("\t").append("<FromUserName><![CDATA["+this.getFromUserName()+"]]></FromUserName>").append("\n");
		sb.append("\t").append("<CreateTime>"+System.currentTimeMillis()+"</CreateTime>").append("\n");
		sb.append("\t").append("<MsgType><![CDATA["+getMsgType()+"]]></MsgType>").append("\n");
		sb.append("\t").append("<Music>").append("\n");
		sb.append("\t").append("<Title><![CDATA["+getTitle()+"]]></Title>").append("\n");
		sb.append("\t").append("<Description><![CDATA["+getDescription()+"]]></Description>").append("\n");
		sb.append("\t").append("<MusicUrl><![CDATA["+getHQMusicUrl()+"]]></MusicUrl>").append("\n");
		sb.append("\t").append("<HQMusicUrl><![CDATA["+getHQMusicUrl()+"]]></HQMusicUrl>").append("\n");
		sb.append("\t").append("</Music>").append("\n");
		sb.append("\t").append("<FuncFlag>0</FuncFlag>").append("\n");
		sb.append("</xml>");
		
		return sb.toString();
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getMusicUrl() {
		return MusicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		MusicUrl = musicUrl;
	}

	public String getHQMusicUrl() {
		return HQMusicUrl;
	}

	public void setHQMusicUrl(String hQMusicUrl) {
		HQMusicUrl = hQMusicUrl;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	

}
