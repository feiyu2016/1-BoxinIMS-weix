/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.wechat.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.boxin.ims.modules.wechat.dao.WeChatDao;
import com.boxin.ims.modules.wechat.entity.WeChat;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.BaseService;

/**
 * 微信公众平台用户Service
 * @author Jakemanse
 * @version 2013-06-17
 */
@Component
@Transactional(readOnly = true)
public class WeChatService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(WeChatService.class);
	
	@Autowired
	private WeChatDao weChatDao;
	
	public WeChat get(Long id) {
		return weChatDao.findOne(id);
	}
	
	public List<WeChat> find(WeChat weChat){
		DetachedCriteria dc = weChatDao.createDetachedCriteria();
		if (weChat.getUser()!=null && weChat.getUser().getId()>0){
			dc.add(Restrictions.eq("user.id", weChat.getUser().getId()));
		}
		if (StringUtils.isNotEmpty(weChat.getName())){
			dc.add(Restrictions.like("name", "%"+weChat.getName()+"%"));
		}
		if (StringUtils.isNotEmpty(weChat.getRemarks())){
			dc.add(Restrictions.like("remarks", "%"+weChat.getRemarks()+"%"));
		}
		dc.add(Restrictions.eq("delFlag", WeChat.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return weChatDao.find( dc);
	}
	
	public WeChat getWeChatByToken(String token){
		
		DetachedCriteria dc = weChatDao.createDetachedCriteria();
		dc.add(Restrictions.eq("token", token));
		 List<WeChat> weChatList = weChatDao.find( dc);
		 if(weChatList!=null && weChatList.size()==1){
			 return weChatList.get(0);
		 }
		
		return null;
		
	}
	public WeChat getWeChatByUserId(Long userId){
		
		DetachedCriteria dc = weChatDao.createDetachedCriteria();
		dc.add(Restrictions.eq("user.id", userId));
		List<WeChat> weChatList = weChatDao.find( dc);
		if(weChatList!=null && weChatList.size()==1){
			return weChatList.get(0);
		}
		
		return null;
		
	}
	
	
	
	public Page<WeChat> find(Page<WeChat> page, WeChat weChat) {
		DetachedCriteria dc = weChatDao.createDetachedCriteria();
		if (weChat.getUser()!=null && weChat.getUser().getId()>0){
			dc.add(Restrictions.eq("user.id", weChat.getUser().getId()));
		}
		if (StringUtils.isNotEmpty(weChat.getName())){
			dc.add(Restrictions.like("name", "%"+weChat.getName()+"%"));
		}
		if (StringUtils.isNotEmpty(weChat.getRemarks())){
			dc.add(Restrictions.like("remarks", "%"+weChat.getRemarks()+"%"));
		}
		dc.add(Restrictions.eq("delFlag", WeChat.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return weChatDao.find(page, dc);
	}
	
	@Transactional(readOnly = false)
	public void save(WeChat weChat) {
		weChatDao.save(weChat);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		weChatDao.deleteById(id);
	}
	
}
