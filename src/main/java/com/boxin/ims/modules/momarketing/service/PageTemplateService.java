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
import com.boxin.ims.modules.momarketing.entity.PageTemplate;
import com.boxin.ims.modules.momarketing.dao.PageTemplateDao;

/**
 * 项目模板Service
 * @author Jakemanse
 * @version 2013-05-26
 */
@Component
@Transactional(readOnly = true)
public class PageTemplateService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(PageTemplateService.class);
	
	@Autowired
	private PageTemplateDao pageTemplateDao;
	
	public PageTemplate get(Long id) {
		return pageTemplateDao.findOne(id);
	}
	
	public Page<PageTemplate> find(Page<PageTemplate> page, PageTemplate pageTemplate) {
		DetachedCriteria dc = pageTemplateDao.createDetachedCriteria();
		if (StringUtils.isNotEmpty(pageTemplate.getName())){
			dc.add(Restrictions.like("name", "%"+pageTemplate.getName()+"%"));
		}
		if (StringUtils.isNotEmpty(pageTemplate.getRemarks())){
			dc.add(Restrictions.like("remarks", "%"+pageTemplate.getRemarks()+"%"));
		}
		dc.add(Restrictions.eq("delFlag", PageTemplate.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return pageTemplateDao.find(page, dc);
	}
	
	@Transactional(readOnly = false)
	public void save(PageTemplate pageTemplate) {
		pageTemplateDao.save(pageTemplate);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		pageTemplateDao.deleteById(id);
	}
	
}
