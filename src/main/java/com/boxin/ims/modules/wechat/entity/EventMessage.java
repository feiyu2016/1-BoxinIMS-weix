package com.boxin.ims.modules.wechat.entity;

/**
 * @author Jakemanse
 * @date 2013-6-20
 * @function <p> 事件推送消息 </p>
 *  <xml>
 *  	<ToUserName><![CDATA[toUser]]></ToUserName>
		<FromUserName><![CDATA[FromUser]]></FromUserName>
		<CreateTime>123456789</CreateTime>
		<MsgType><![CDATA[event]]></MsgType>
		<Event><![CDATA[EVENT]]></Event>
		<EventKey><![CDATA[EVENTKEY]]></EventKey>
	</xml>
 */
public class EventMessage extends Message {
	public final static String MSG_TYPE = "event";

	@Override
	public String getMsgType() {
		return "event";
	}
	
	

	@Override
	public String replyMessage() {
		StringBuffer sb  = new StringBuffer();
		sb.append("<xml>");
		sb.append("\t").append("<ToUserName><![CDATA["+this.getToUserName()+"]]></ToUserName>").append("\n");
		sb.append("\t").append("<FromUserName><![CDATA["+this.getFromUserName()+"]]></FromUserName>").append("\n");
		sb.append("\t").append("<CreateTime>"+System.currentTimeMillis()+"</CreateTime>").append("\n");
		sb.append("\t").append("<Content><![CDATA["+this.getContent()+"]]></Content>").append("\n");
		sb.append("\t").append("<MsgType><![CDATA["+TextMessage.MSG_TYPE+"]]></MsgType>").append("\n");
		sb.append("\t").append("<FuncFlag>0</FuncFlag>").append("\n");
		sb.append("</xml>");
		
		return sb.toString();
	}
	
	
	/**
	 * @author Jakemanse
	 * @time 2013-6-20  下午11:28:13
	 * @function <p> 回复图文消息 </p>
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
	 * @return
	 */
	public String replyImageMessage(ImageMessage imageMessage){
		
		return imageMessage.replyMessage();
		
	}
	
	/**
	 * @author Jakemanse
	 * @time 2013-6-20  下午11:24:25
	 * @function <p>  </p>
	 * @return
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
	public String replyMusicMessage(MusicMessage musicMessage){
		return musicMessage.replyMessage();
		
	}
	
	
	
	

}
