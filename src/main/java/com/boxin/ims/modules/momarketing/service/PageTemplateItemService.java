/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.momarketing.service;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.BaseService;
import com.boxin.ims.modules.momarketing.entity.PageTemplateItem;
import com.boxin.ims.modules.momarketing.dao.PageTemplateItemDao;

/**
 * 项目模板模板实例页Service
 * @author Jakemanse
 * @version 2013-05-26
 */
@Component
@Transactional(readOnly = true)
public class PageTemplateItemService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(PageTemplateItemService.class);
	
	@Autowired
	private PageTemplateItemDao pageTemplateItemDao;
	
	public PageTemplateItem get(Long id) {
		return pageTemplateItemDao.findOne(id);
	}
	
	public Page<PageTemplateItem> find(Page<PageTemplateItem> page, PageTemplateItem pageTemplateItem) {
		DetachedCriteria dc = pageTemplateItemDao.createDetachedCriteria();
		if (pageTemplateItem.getUser()!=null && pageTemplateItem.getUser().getId()>0){
			dc.add(Restrictions.eq("user.id", pageTemplateItem.getUser().getId()));
		}
		if (StringUtils.isNotEmpty(pageTemplateItem.getName())){
			dc.add(Restrictions.like("name", "%"+pageTemplateItem.getName()+"%"));
		}
		if (StringUtils.isNotEmpty(pageTemplateItem.getRemarks())){
			dc.add(Restrictions.like("remarks", "%"+pageTemplateItem.getRemarks()+"%"));
		}
		dc.add(Restrictions.eq("delFlag", PageTemplateItem.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return pageTemplateItemDao.find(page, dc);
	}
	
	@Transactional(readOnly = false)
	public void save(PageTemplateItem pageTemplateItem) {
		pageTemplateItemDao.save(pageTemplateItem);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		pageTemplateItemDao.deleteById(id);
	}
	
}
