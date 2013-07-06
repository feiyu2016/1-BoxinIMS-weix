package com.boxin.ims.modules.wechat.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.boxin.ims.modules.wechat.entity.Zhifubao;
import com.boxin.ims.modules.wechat.service.ZhifubaoService;

@Service
public class ZFBUtils implements ApplicationContextAware{
	
	private static ZhifubaoService zhifubaoService;
	private static String UID_KEK = "";
	
	public static Zhifubao getZhifubaoByUserId(String userId){
		Zhifubao zhifubao = zhifubaoService.getZhifubaoByUserId(Long.parseLong(userId));
		return zhifubao;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
				zhifubaoService = (ZhifubaoService)applicationContext.getBean("zhifubaoService");
	}

}
