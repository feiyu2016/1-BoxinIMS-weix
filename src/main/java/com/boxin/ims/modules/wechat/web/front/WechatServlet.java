package com.boxin.ims.modules.wechat.web.front;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boxin.ims.modules.wechat.utils.WeChatUtils;

public class WechatServlet extends HttpServlet{
	
	public final static String Token = "jakemanse";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Map map = JSON.parse();
		
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = 	   request.getParameter("nonce");
		
		
		
		String[] ArrTmp = { Token, timestamp, nonce };
		Arrays.sort(ArrTmp);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < ArrTmp.length; i++) {
			sb.append(ArrTmp[i]);
		}
//		String pwd = Encrypt(sb.toString());
		String pwd = sb.toString();
		String echostr = request.getParameter("echostr");
		System.out.println("pwd=="+pwd);
		System.out.println("echostr=="+echostr);
		response.getWriter().print(echostr);
		if(pwd.equals(signature)){
			if(!"".equals(echostr) && echostr != null){
			}
		}
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPost(req, resp);
	}

}
