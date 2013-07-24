package com.boxin.ims.modules.wechat.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.boxin.ims.modules.wechat.entity.Session;

/**
 * @author Jakemanse
 * @date 2013-7-22
 * @function <p> 微信会话</p>
 */
public class SessionUtils {
	
	public static Map<String,Session> sessionMap = new HashMap<String,Session>();
	
	
	
	public static String getLastUpContent(String weixinId){
		Session session = sessionMap.get(weixinId);
		if(session!=null){
			List<String> contents = session.getChatList();
			if(contents!=null && !contents.isEmpty()){
				int size = contents.size();
				return contents.get(size-2);
			}
		}
		return "";
	}
	
	
	public static boolean isExists(String weixinId){
		return sessionMap.containsKey(weixinId);
	}
	
	
	/**
	 * @author Jakemanse
	 * @time 2013-7-22  下午12:43:57
	 * @function <p> 添加会话信息 </p>
	 * @param weixinId
	 * @param content
	 */
	public static void addSession(String weixinId,String content){
		if(!isExists(weixinId)){
			Session session = new Session();
			session.addContent(content);
			
			sessionMap.put(weixinId, session);
		}else{
			Session session = sessionMap.get(weixinId);
			session.addContent(content);
		}
	}
	
	
	
	
	
	
			

}
