package com.boxin.ims.modules.wechat.entity;

import java.util.List;
import java.util.Map;

public class ImageMessage extends Message {
	
	public final static String MSG_TYPE = "news";
	private String PicUrl;
	private String Title;
	private String Description;
	private String Url;
	private String ArticleCount;

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
		return MSG_TYPE;
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	
	
	
	/**
	 * <xml>
		 <ToUserName><![CDATA[toUser]]></ToUserName>
		 <FromUserName><![CDATA[fromUser]]></FromUserName>
		 <CreateTime>12345678</CreateTime>
		 <MsgType><![CDATA[news]]></MsgType>
		 <ArticleCount>2</ArticleCount>
		 <Articles>
		 <item>
		 <Title><![CDATA[title1]]></Title> 
		 <Description><![CDATA[description1]]></Description>
		 <PicUrl><![CDATA[picurl]]></PicUrl>
		 <Url><![CDATA[url]]></Url>
		 </item>
		 <item>
		 <Title><![CDATA[title]]></Title>
		 <Description><![CDATA[description]]></Description>
		 <PicUrl><![CDATA[picurl]]></PicUrl>
		 <Url><![CDATA[url]]></Url>
		 </item>
		 </Articles>
		 <FuncFlag>1</FuncFlag>
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
		
		sb.append("\t").append("<ArticleCount>"+getArticleCount()+"</ArticleCount>").append("\n");
		sb.append("\t").append("<Articles>").append("\n");
		sb.append("\t").append("<item>").append("\n");
		sb.append("\t").append("<Title><![CDATA["+getTitle()+"]]></Title>").append("\n");
		sb.append("\t").append("<Description><![CDATA["+getDescription()+"]]></Description>").append("\n");
		sb.append("\t").append("<PicUrl><![CDATA["+getPicUrl()+"]]></PicUrl>").append("\n");
		sb.append("\t").append("<Url><![CDATA["+getUrl()+"]]></Url>").append("\n");
		sb.append("\t").append("</item>").append("\n");
		sb.append("\t").append("</Articles>").append("\n");
		sb.append("\t").append("<FuncFlag>1</FuncFlag>").append("\n");
		sb.append("</xml>");
		
		return sb.toString();
	}
	
	
	public String replyMessage(List<NewsReply> newsReplyList){
		
		StringBuffer sb  = new StringBuffer();
		sb.append("<xml>");
		sb.append("\t").append("<ToUserName><![CDATA["+this.getToUserName()+"]]></ToUserName>").append("\n");
		sb.append("\t").append("<FromUserName><![CDATA["+this.getFromUserName()+"]]></FromUserName>").append("\n");
		sb.append("\t").append("<CreateTime>"+System.currentTimeMillis()+"</CreateTime>").append("\n");
		sb.append("\t").append("<MsgType><![CDATA["+getMsgType()+"]]></MsgType>").append("\n");
		
		sb.append("\t").append("<ArticleCount>"+newsReplyList.size()+"</ArticleCount>").append("\n");
		sb.append("\t").append("<Articles>").append("\n");
		for(NewsReply reply : newsReplyList){
			
			sb.append("\t").append("<item>").append("\n");
			sb.append("\t").append("<Title><![CDATA["+reply.getTitle()+"]]></Title>").append("\n");
			sb.append("\t").append("<Description><![CDATA["+reply.getDescription()+"]]></Description>").append("\n");
			sb.append("\t").append("<PicUrl><![CDATA["+reply.getPicUrl()+"]]></PicUrl>").append("\n");
			sb.append("\t").append("<Url><![CDATA["+reply.getUrl()+"]]></Url>").append("\n");
			sb.append("\t").append("</item>").append("\n");
		}
		
		sb.append("\t").append("</Articles>").append("\n");
		sb.append("\t").append("<FuncFlag>1</FuncFlag>").append("\n");
		sb.append("</xml>");
		
		return sb.toString();
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public String getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(String articleCount) {
		ArticleCount = articleCount;
	}

	
	
	
	
	
	
}
