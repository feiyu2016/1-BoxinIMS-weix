package com.boxin.ims.modules.wechat.entity;

import java.util.ArrayList;
import java.util.List;

public class Session{
	private Long startTime = System.currentTimeMillis();
	private List<String> chatList =  new ArrayList<String>();
	
	public Session(){
		
	}
	
	public Long getStartTime() {
		return startTime;
	}
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	public List<String> getChatList() {
		return chatList;
	}
	public void setChatList(List<String> chatList) {
		this.chatList = chatList;
	}
	
	public void addContent(String content){
		this.chatList.add(content);
	}
	
	
	
}