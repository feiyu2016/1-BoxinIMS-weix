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
import com.boxin.ims.modules.momarketing.entity.CompanyNews;
import com.boxin.ims.modules.momarketing.dao.CompanyNewsDao;

/**
 * 公司动态Service
 * @author Jakemanse
 * @version 2013-05-28
 */
@Component
@Transactional(readOnly = true)
public class CompanyNewsService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(CompanyNewsService.class);
	
	@Autowired
	private CompanyNewsDao companyNewsDao;
	
	public CompanyNews get(Long id) {
		return companyNewsDao.findOne(id);
	}
	
	public Page<CompanyNews> find(Page<CompanyNews> page, CompanyNews companyNews) {
		DetachedCriteria dc = companyNewsDao.createDetachedCriteria();
		if (companyNews.getUser()!=null && companyNews.getUser().getId()>0){
			dc.add(Restrictions.eq("user.id", companyNews.getUser().getId()));
		}
		if (StringUtils.isNotEmpty(companyNews.getName())){
			dc.add(Restrictions.like("name", "%"+companyNews.getName()+"%"));
		}
		if (StringUtils.isNotEmpty(companyNews.getRemarks())){
			dc.add(Restrictions.like("remarks", "%"+companyNews.getRemarks()+"%"));
		}
		dc.add(Restrictions.eq("delFlag", CompanyNews.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return companyNewsDao.find(page, dc);
	}
	
	@Transactional(readOnly = false)
	public void save(CompanyNews companyNews) {
		companyNewsDao.save(companyNews);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		companyNewsDao.deleteById(id);
	}
	
}
