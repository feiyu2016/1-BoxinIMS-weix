/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.wechat.service;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.boxin.ims.modules.wechat.dao.NewsReplyDao;
import com.boxin.ims.modules.wechat.dao.WechatWelcomeDao;
import com.boxin.ims.modules.wechat.entity.ImageMessage;
import com.boxin.ims.modules.wechat.entity.NewsReply;
import com.boxin.ims.modules.wechat.entity.WeChat;
import com.boxin.ims.modules.wechat.entity.WechatWelcome;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.BaseService;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

/**
 * 欢迎词Service
 * @author Jakemanse
 * @version 2013-06-20
 */
@Component
@Transactional(readOnly = true)
public class WechatWelcomeService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(WechatWelcomeService.class);
	
	@Autowired
	private WechatWelcomeDao wechatWelcomeDao;
	@Autowired
	private WeChatService weChatService;
	
	@Autowired
	private NewsReplyDao newsReplyDao;
	
	public WechatWelcome get(Long id) {
		return wechatWelcomeDao.findOne(id);
	}
	
	public Page<WechatWelcome> find(Page<WechatWelcome> page, WechatWelcome wechatWelcome) {
		DetachedCriteria dc = wechatWelcomeDao.createDetachedCriteria();
//		if (wechatWelcome.getWeChat()!=null && wechatWelcome.getWeChat().getId()>0){
//			dc.add(Restrictions.eq("weChat.id", wechatWelcome.getWeChat().getId()));
//		}
		dc.add(Restrictions.eq("delFlag", WechatWelcome.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return wechatWelcomeDao.find(page, dc);
	}
	
	@Transactional(readOnly = false)
	public void save(WechatWelcome wechatWelcome) {
		wechatWelcomeDao.save(wechatWelcome);
		WeChat weChat = weChatService.getWeChatByUserId(UserUtils.getUser().getId());
		if(weChat != null){
			weChat.setWechatWelcome(wechatWelcome);
			weChatService.save(weChat);
			
			if(ImageMessage.MSG_TYPE.equals(wechatWelcome.getType())){
				NewsReply newsReply = new NewsReply();
				newsReply.setFilePath(wechatWelcome.getFilePath());
				newsReply.setWechatWelcome(wechatWelcome);
				newsReply.setUrl(wechatWelcome.getUrl());
				newsReply.setTitle(wechatWelcome.getTitle());
				newsReply.setDescription(wechatWelcome.getDescription());
				newsReply.setIsWelcome(true);
				newsReplyDao.save(newsReply);
				//newsReplyDao保存后得到ID 再更新
				newsReply.setPicUrl("http://www.hdzhx.com/zxims/f/mobsite/wp/vr?wid="+weChat.getId()+"&rid="+newsReply.getId()+"&vtype=reply&ctime="+System.currentTimeMillis());
				newsReplyDao.save(newsReply);
				
				
			}else{
				
			}
			
			wechatWelcome.setMusicUrl("http://www.hdzhx.com/zxims/f/mobsite/wp/vr?wid="+weChat.getId()+"&rid="+wechatWelcome.getId()+"&type="+wechatWelcome.getType()+"&ctime="+System.currentTimeMillis());
			wechatWelcome.setPicUrl("http://www.hdzhx.com/zxims/f/mobsite/wp/vr?wid="+weChat.getId()+"&rid="+wechatWelcome.getId()+"&type="+wechatWelcome.getType()+"&ctime="+System.currentTimeMillis());
		}
		wechatWelcomeDao.save(wechatWelcome);
	}
	 
	@Transactional(readOnly = false)
	public void delete(Long id) {
		wechatWelcomeDao.deleteById(id);
	}
	
}
