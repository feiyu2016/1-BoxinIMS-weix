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

import com.boxin.ims.modules.wechat.dao.WechatConfigDao;
import com.boxin.ims.modules.wechat.entity.WechatConfig;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.BaseService;

/**
 * 微信上下行数据交互Service
 * @author Jakemanse
 * @version 2013-06-19
 */
@Component
@Transactional(readOnly = true)
public class WechatConfigService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(WechatConfigService.class);
	
	@Autowired
	private WechatConfigDao wechatConfigDao;
	
	public WechatConfig get(Long id) {
		return wechatConfigDao.findOne(id);
	}
	
	public Page<WechatConfig> find(Page<WechatConfig> page, WechatConfig wechatConfig) {
		DetachedCriteria dc = wechatConfigDao.createDetachedCriteria();
		if (wechatConfig.getWeChat()!=null && wechatConfig.getWeChat().getId()>0){
			dc.add(Restrictions.eq("weChat.id", wechatConfig.getWeChat().getId()));
		}
		if (StringUtils.isNotEmpty(wechatConfig.getUpContent())){
			dc.add(Restrictions.like("upContent", "%"+wechatConfig.getUpContent()+"%"));
		}
		dc.add(Restrictions.eq("delFlag", WechatConfig.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return wechatConfigDao.find(page, dc);
	}
	
	
	public List<WechatConfig> find(WechatConfig wechatConfig){
		DetachedCriteria dc = wechatConfigDao.createDetachedCriteria();
		if (wechatConfig.getWeChat()!=null && wechatConfig.getWeChat().getId()>0){
			dc.add(Restrictions.eq("weChat.id", wechatConfig.getWeChat().getId()));
		}
		if (StringUtils.isNotEmpty(wechatConfig.getUpContent())){
			dc.add(Restrictions.like("upContent", "%"+wechatConfig.getUpContent()+"%"));
		}
		dc.addOrder(Order.desc("id"));
		return wechatConfigDao.find( dc);
	}
	
	/**
	 * @author Jakemanse
	 * @time 2013-6-26  上午1:59:51
	 * @function <p> 根据设置的关键词得一个配置 </p>
	 * @param content
	 * @return
	 */
	public WechatConfig getByUpcontent(String content){
		DetachedCriteria dc = wechatConfigDao.createDetachedCriteria();
		if (StringUtils.isNotEmpty(content)){
			dc.add(Restrictions.eq("upContent",content));
		}
		dc.addOrder(Order.desc("id"));
		List<WechatConfig> configList =  wechatConfigDao.find( dc);
		return (configList==null || configList.isEmpty()) ?null : configList.get(0);
	}
	
	
	@Transactional(readOnly = false)
	public void save(WechatConfig wechatConfig) {
		wechatConfigDao.save(wechatConfig);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		wechatConfigDao.deleteById(id);
	}
	
}
