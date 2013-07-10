/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.wechat.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.boxin.framework.base.dao.DaoHelper;
import com.boxin.ims.modules.wechat.dao.NewsReplyDao;
import com.boxin.ims.modules.wechat.dao.WechatConfigDao;
import com.boxin.ims.modules.wechat.entity.ImageMessage;
import com.boxin.ims.modules.wechat.entity.NewsReply;
import com.boxin.ims.modules.wechat.entity.WechatConfig;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.BaseService;

/**
 * 图文富内容回复Service
 * @author Jakemanse
 * @version 2013-06-21
 */
@Component
@Transactional(readOnly = true)
public class NewsReplyService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(NewsReplyService.class);
	
	@Autowired
	private NewsReplyDao newsReplyDao;
	
	@Autowired
	private WechatConfigDao wechatConfigDao;
	@Autowired
	private WechatConfigService wechatConfigService;
	
	@Autowired
	private DaoHelper daoHelper;
	
	public NewsReply get(Long id) {
		return newsReplyDao.findOne(id);
	}
	
	public Page<NewsReply> find(Page<NewsReply> page, NewsReply newsReply) {
		DetachedCriteria dc = newsReplyDao.createDetachedCriteria();
		if (newsReply.getWechatConfig()!=null && newsReply.getWechatConfig().getId()>0){
			dc.add(Restrictions.eq("wechatConfig.id", newsReply.getWechatConfig().getId()));
		}else{
			dc.add(Restrictions.eq("weChat.id", newsReply.getWeChat().getId()));
		}
		if (StringUtils.isNotEmpty(newsReply.getTitle())){
			dc.add(Restrictions.like("title", "%"+newsReply.getTitle()+"%"));
		}
		if (StringUtils.isNotEmpty(newsReply.getDescription())){
			dc.add(Restrictions.like("description", "%"+newsReply.getDescription()+"%"));
		}
		dc.add(Restrictions.eq("delFlag", NewsReply.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("ord"));
		return newsReplyDao.find(page, dc);
	}
	
	public List<NewsReply> findNewsReply(Map<String,String> params){
		
		return  daoHelper.queryForList("com.boxin.ims.wechat.selectNewsReplys", params);
	}
	
	@Transactional(readOnly = false)
	public void save(NewsReply newsReply) {
		//是否要新一个WechatConfig
		if(newsReply.getWechatConfig().getId() == null){
			WechatConfig config = wechatConfigService.getByUpcontent(newsReply.getWechatConfig().getUpContent());
			if(config != null){
				newsReply.setWechatConfig(config);
			}
			newsReply.getWechatConfig().setMsgType(ImageMessage.MSG_TYPE);
			wechatConfigDao.save(newsReply.getWechatConfig());
		}
		
		
		newsReplyDao.save(newsReply);
		
		newsReply.setPicUrl("http://www.hdzhx.com/zxims/f/mobsite/wp/vr?wid="+newsReply.getWechatConfig().getWeChat().getId()+"&rid="+newsReply.getId()+"&vtype=reply&ctime="+System.currentTimeMillis());
		//再更新
		newsReplyDao.save(newsReply);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		newsReplyDao.deleteById(id);
	}
	
	
	
	
}
