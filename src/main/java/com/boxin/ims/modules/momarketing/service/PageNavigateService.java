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
import com.boxin.ims.modules.momarketing.entity.PageNavigate;
import com.boxin.ims.modules.momarketing.dao.PageNavigateDao;

/**
 * 项目模板模板页导航Service
 * @author Jakemanse
 * @version 2013-05-26
 */
@Component
@Transactional(readOnly = true)
public class PageNavigateService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(PageNavigateService.class);
	
	@Autowired
	private PageNavigateDao pageNavigateDao;
	
	public PageNavigate get(Long id) {
		return pageNavigateDao.findOne(id);
	}
	
	public Page<PageNavigate> find(Page<PageNavigate> page, PageNavigate pageNavigate) {
		DetachedCriteria dc = pageNavigateDao.createDetachedCriteria();
		if (pageNavigate.getUser()!=null && pageNavigate.getUser().getId()>0){
			dc.add(Restrictions.eq("user.id", pageNavigate.getUser().getId()));
		}
		if (StringUtils.isNotEmpty(pageNavigate.getName())){
			dc.add(Restrictions.like("name", "%"+pageNavigate.getName()+"%"));
		}
		if (StringUtils.isNotEmpty(pageNavigate.getRemarks())){
			dc.add(Restrictions.like("remarks", "%"+pageNavigate.getRemarks()+"%"));
		}
		dc.add(Restrictions.eq("delFlag", PageNavigate.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return pageNavigateDao.find(page, dc);
	}
	
	@Transactional(readOnly = false)
	public void save(PageNavigate pageNavigate) {
		pageNavigateDao.save(pageNavigate);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		pageNavigateDao.deleteById(id);
	}
	
}
