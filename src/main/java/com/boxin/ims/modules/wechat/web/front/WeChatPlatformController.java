package com.boxin.ims.modules.wechat.web.front;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boxin.framework.base.dao.DaoHelper;
import com.boxin.ims.modules.wechat.entity.EventMessage;
import com.boxin.ims.modules.wechat.entity.ImageMessage;
import com.boxin.ims.modules.wechat.entity.MusicMessage;
import com.boxin.ims.modules.wechat.entity.NewsReply;
import com.boxin.ims.modules.wechat.entity.Region;
import com.boxin.ims.modules.wechat.entity.TextMessage;
import com.boxin.ims.modules.wechat.entity.WeChat;
import com.boxin.ims.modules.wechat.entity.Weather;
import com.boxin.ims.modules.wechat.entity.WechatConfig;
import com.boxin.ims.modules.wechat.entity.WechatWelcome;
import com.boxin.ims.modules.wechat.service.NewsReplyService;
import com.boxin.ims.modules.wechat.service.RegionService;
import com.boxin.ims.modules.wechat.service.WeChatService;
import com.boxin.ims.modules.wechat.service.WechatConfigService;
import com.boxin.ims.modules.wechat.service.WechatWelcomeService;
import com.boxin.ims.modules.wechat.utils.WeChatUtils;
import com.boxin.ims.modules.wechat.utils.XMLUtils;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.service.SystemService;

@Controller
@RequestMapping(value = Global.MOBILE_SITE_PATH + "/wp")
public class WeChatPlatformController  extends BaseController{
	private final static Logger logger = Logger.getLogger(WeChatPlatformController.class);
	
	@Autowired
	WeChatService weChatService;
	
	@Autowired
	RegionService regionService;
	
	@Autowired
	SystemService systemService;
	
	@Autowired
	WechatConfigService wechatConfigService;
	
	@Autowired
	WechatWelcomeService  wechatWelcomeService;
	
	@Autowired
	NewsReplyService newsReplyService;
	
	@Autowired
	DaoHelper daoHelper;
	
	
	@RequestMapping(value = {"chat", ""})
	public void chat(HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			
			String method = request.getMethod();
			if("GET".equals(method)){
				valid(request,response,model);
				return;
			}
			
			String wid	 =  request.getParameter("wid");		//后台设置ID WeChat 的ID
			WeChat weChat = weChatService.get(Long.parseLong(wid));
			String reply = weChat.getRemarks();	//默认回复内容
			
			//1.获取自己所有服务列表
			
			//2.自定义问题签
			WechatConfig wechatConfig = new WechatConfig();
			wechatConfig.setWeChat(weChat);
			List<WechatConfig> configList = wechatConfigService.find( wechatConfig);	//关键词列表
			
			
			StringBuffer sb = new StringBuffer();
			BufferedReader bReader =   request.getReader();
			String line = "";
			while((line = bReader.readLine()) != null){
				sb.append(line);
			}
			
			logger.debug("接收到的请求内容是："+sb.toString());
			
			
			
			Map<String,String> map = XMLUtils.xml2Map(sb.toString());
			TextMessage textMessage = new TextMessage(map);
			//上行数据
			String upcon = textMessage.getContent();	//用户输入的内容
			
			textMessage.setContent(reply);	//默认自动回复的内容
			reply = textMessage.replyMessage();
			
//			//没有找到对应的回复内容时，默认回复欢迎词。
//			WechatWelcome wechatWelcome = weChat.getWechatWelcome();
//			if(MusicMessage.MSG_TYPE.equals(wechatWelcome.getType())){
//				MusicMessage musicMessage = new MusicMessage(map);
//				musicMessage.setMusicUrl(wechatWelcome.getMusicUrl() );
//				musicMessage.setHQMusicUrl(wechatWelcome.getMusicUrl());
//				musicMessage.setTitle(wechatWelcome.getTitle());
//				musicMessage.setDescription(wechatWelcome.getDescription());
//				reply =  musicMessage.replyMessage();
//				
//			}else if(ImageMessage.MSG_TYPE.equals(wechatWelcome.getType())){	//回复图文信息
//				ImageMessage imageMessage = new ImageMessage(map);
//				imageMessage.setArticleCount("1");
//				imageMessage.setTitle(wechatWelcome.getTitle());
//				imageMessage.setDescription(wechatWelcome.getDescription());
//				imageMessage.setPicUrl(wechatWelcome.getPicUrl());
//				imageMessage.setUrl(wechatWelcome.getUrl());
//				reply =  imageMessage.replyMessage();
//			}else{
//				TextMessage textMessage = new TextMessage(map);
//				textMessage.setContent(wechatWelcome.getContent());
//				reply =  textMessage.replyMessage();
//			}
			
			
			
			
			//判断事件,回复欢迎词
			String MsgType = map.get("xml.MsgType");
			if(EventMessage.MSG_TYPE.equals(MsgType)){
				
				if(EventMessage.EVENT_TYPE_JOIN.equals(map.get("xml.Event"))){	//订阅事件
					WechatWelcome wechatWelcome = weChat.getWechatWelcome();
//					//选择默认的欢迎回复内容
					if(MusicMessage.MSG_TYPE.equals(wechatWelcome.getType())){
						MusicMessage musicMessage = new MusicMessage(map);
						musicMessage.setMusicUrl(wechatWelcome.getMusicUrl() );
						musicMessage.setHQMusicUrl(wechatWelcome.getMusicUrl());
						musicMessage.setTitle(wechatWelcome.getTitle());
						musicMessage.setDescription(wechatWelcome.getDescription());
						response.getWriter().print(musicMessage.replyMessage() );
						System.out.println("回复的图文内容:"+musicMessage.replyMessage());
						return ;
						
					}else if(ImageMessage.MSG_TYPE.equals(wechatWelcome.getType())){	//回复图文信息
						ImageMessage imageMessage = new ImageMessage(map);
						imageMessage.setArticleCount("1");
						imageMessage.setTitle(wechatWelcome.getTitle());
						imageMessage.setDescription(wechatWelcome.getDescription());
						imageMessage.setPicUrl(wechatWelcome.getPicUrl());
						imageMessage.setUrl(wechatWelcome.getUrl());
						response.getWriter().print(imageMessage.replyMessage() );
						System.out.println("回复的图文内容:"+imageMessage.replyMessage());
						return ;
					}else{
						textMessage.setContent(wechatWelcome.getContent());
						response.getWriter().print(textMessage.replyMessage() );
						printReplyLogger(textMessage.replyMessage() );
						return;
					}
					
				}else{//其它事件
					
					return ;
				}
				
			}
			
			
			
			
			if(upcon.endsWith("天气")){//查天气
				Region region = new Region();
				region.setName(upcon.replaceAll("天气", "").trim());
				List<Region> regions = 	regionService.find(region);
				reply = "未找到【"+textMessage.getContent()+"】的天气信息.";
				if(regions !=null && regions.size()>0){//打到了对应的天气的信息
					region = regions.get(0);
					String strjson = WeChatUtils.getWeatherJson(region.getCode());
					JSONObject json  = JSONObject.fromObject(strjson); //object.getString("weatherinfo")
					JSONObject jsonw = JSONObject.fromObject(json.getString("weatherinfo"));
					Weather weather = WeChatUtils.convertJsonToWeather(  jsonw);
					reply = weather.toMailWeatherString();
					printReplyLogger(reply);
					return ;
				}else{
					//未找到。
				}
				
			}else{
				WechatConfig cfg = 	WeChatUtils.getConfigByUpContent(configList, upcon);
				if(cfg != null){//找到对应的交互答案
					if(ImageMessage.MSG_TYPE.equals(cfg.getMsgType())){
						ImageMessage imageMessage = new ImageMessage(map);
						Map<String,String> params = new HashMap<String,String>();
						params.put("configId", ""+cfg.getId());
						List<NewsReply> newsReplyList = daoHelper.queryForList("com.boxin.ims.wechat.selectNewsReplys", params);	//newsReplyService.findNewsReply(params);
						reply = imageMessage.replyMessage(newsReplyList);
						response.getWriter().print(reply );
						logger.debug(reply);
						return ;
					}else if(TextMessage.MSG_TYPE.equals(cfg.getMsgType())){
						TextMessage txtMsg = new TextMessage(map);
						txtMsg.setContent(cfg.getDownContent());
						response.getWriter().print(txtMsg.replyMessage() );
						printReplyLogger(txtMsg.replyMessage());
						return ;
					}
				} 
			}
			
			printReplyLogger(reply);
			response.getWriter().print(reply);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * @author Jakemanse
	 * @time 2013-6-26  上午10:26:00
	 * @function <p> 回复内容 </p>
	 * @param content
	 */
	private void printReplyLogger(String content){
		logger.debug("回复的全内容是:"+content);
	}
	
	@RequestMapping(value =  "valid")
	public void valid(HttpServletRequest request, HttpServletResponse response, Model model){
		
		
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = 	   request.getParameter("nonce");
		String wid		 =  request.getParameter("wid");		//后台设置ID WeChat 的ID
		String Token = "";
		if(!StringUtils.isBlank(wid)){  //从平台中获取Token 进行绑定
			try {
				User user = systemService.getUser(Long.parseLong(wid));
				WeChat weChat  = weChatService.get(Long.parseLong(wid));
				if(weChat!=null){
					Token  = weChat.getToken();
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("查找ID为:"+wid+"的用户Token失败!");
			}
		}
		
		try {
			
			String[] ArrTmp = { Token, timestamp, nonce };
			Arrays.sort(ArrTmp);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < ArrTmp.length; i++) {
				sb.append(ArrTmp[i]);
			}
			String pwd = Encrypt(sb.toString());
//			String pwd = sb.toString();
			String echostr = request.getParameter("echostr");
			System.out.println("pwd=="+pwd);
			System.out.println("echostr=="+echostr);
			if(pwd.equals(signature)){
				if(!"".equals(echostr) && echostr != null){
					response.getWriter().print(echostr);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * @author Jakemanse
	 * @time 2013-6-21  上午10:09:30
	 * @function <p> 图片或声音的资源文件 URL </p>
	 * @param request
	 * @param response
	 * @return
	 */
	
	@RequestMapping(value =  "vr")
	public String viewResource(HttpServletRequest request, HttpServletResponse response){
		
		String rid = request.getParameter("rid");
		String fileName = request.getParameter("fname");
		String wid = request.getParameter("wid");		// 
		String vtype = request.getParameter("vtype");	//访问类型   reply和welcome
		
		WechatConfig config = 	wechatConfigService.get(Long.parseLong(wid));
		
		String filepath = "";
		String type = ImageMessage.MSG_TYPE;
		if("reply".equals(vtype)){	//多图文时 查NewsReply表中的资源
			NewsReply newsReply = 	newsReplyService.get(Long.parseLong(rid));
			filepath = newsReply.getFilePath();
		}else{
			WechatWelcome welcome =  config.getWeChat().getWechatWelcome();
			type = welcome.getType();
			filepath = welcome.getFilePath();
		}
		
		logger.debug("访问要下载的图片文件位置是为 filepath :"+filepath);
		
		if(MusicMessage.MSG_TYPE.equals(type)){	//音乐
			try {
				//1.回复的声音文件
				 File file = new File(filepath);
				 OutputStream outputStream = response.getOutputStream();
				 InputStream inputStream = new FileInputStream(file);
				 
				 response.setContentType("audio/mp3");
				 
				 byte[] buffer = new byte[1024];
				 int i = -1;
				 while ((i = inputStream.read(buffer)) != -1) {
				  outputStream.write(buffer, 0, i);
				 }
				 outputStream.flush();
				 outputStream.close();
				 inputStream.close();
				 outputStream = null;
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}else if(ImageMessage.MSG_TYPE.equals(type)){
			try {
				
				//2.回复的图文
				File file = new File(filepath);
//				BufferedImage image = 	ImageIO.read(file);
				
				OutputStream outputStream = response.getOutputStream();
//				ImageIO.write(image, "JPEG", out);
//				
//				out.flush();
//				out.close();
				 String contentType = "image/jpeg";
				 if(filepath.toLowerCase().endsWith("gif")){
					 contentType = "image/gif";
				 }
				 response.setContentLength((int)file.length());
				 response.setContentType(contentType+";charset=UTF-8"); 
				 InputStream inputStream = new FileInputStream(file);
				 byte[] buffer = new byte[1024];
				 int i = -1;
				 while ((i = inputStream.read(buffer)) != -1) {
				  outputStream.write(buffer, 0, i);
				 }
				 outputStream.flush();
				 outputStream.close();
				 inputStream.close();
				 outputStream = null;
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		return null;
	}
	
	
	
	
	
	public String Encrypt(String strSrc) {
		MessageDigest md = null;
		String strDes = null;

		byte[] bt = strSrc.getBytes();
		try {
			md = MessageDigest.getInstance("SHA-1");
			md.update(bt);
			strDes = bytes2Hex(md.digest()); //to HexString
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Invalid algorithm.");
			return null;
		}
		return strDes;
	}

	public String bytes2Hex(byte[] bts) {
		String des = "";
		String tmp = null;
		for (int i = 0; i < bts.length; i++) {
			tmp = (Integer.toHexString(bts[i] & 0xFF));
			if (tmp.length() == 1) {
				des += "0";
			}
			des += tmp;
		}
		return des;
	}
	
	public boolean isChinese(String str){  
	     boolean result=false;  
	     for (int i = 0; i < str.length(); i++){  
	          int chr1 = (char) str.charAt(i);  
	          if(chr1>=19968&&chr1<=171941){//汉字范围 \u4e00-\u9fa5 (中文)  
	              result = true;  
	          } 
	     }  
	     return result;  
	} 
	
	
	
	
	
	
	

}
