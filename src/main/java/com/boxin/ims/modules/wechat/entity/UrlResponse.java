package com.boxin.ims.modules.wechat.entity;

public class UrlResponse extends Message{
	
	private String PicUrl;

	@Override
	public String getMsgType() {
		return "image";
	}

	@Override
	public String replyMessage() {
		
		return null;
	}
	
	

}
