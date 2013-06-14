/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.ecard.service;

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

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.BaseService;
import com.boxin.ims.modules.ecard.entity.OrganInfo;
import com.boxin.ims.modules.ecard.dao.OrganInfoDao;
import com.boxin.ims.modules.momarketing.entity.CompanyNews;

/**
 * 单位信息Service
 * @author Jakemanse
 * @version 2013-06-10
 */
@Component
@Transactional(readOnly = true)
public class OrganInfoService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(OrganInfoService.class);
	
	@Autowired
	private OrganInfoDao organInfoDao;
	
	public OrganInfo get(Long id) {
		return organInfoDao.findOne(id);
	}
	
	public OrganInfo getByUserId(Long userId) {
		
		List<OrganInfo>  organList = organInfoDao.find(" from OrganInfo where user.id = ? ", userId);
		if(organList!=null && !organList.isEmpty()){
			return organList.get(0);
		}
		return null;
		
	}
	
	public Page<OrganInfo> find(Page<OrganInfo> page, OrganInfo organInfo) {
		DetachedCriteria dc = organInfoDao.createDetachedCriteria();
		if (organInfo.getUser()!=null && organInfo.getUser().getId()>0){
			dc.add(Restrictions.eq("user.id", organInfo.getUser().getId()));
		}
		if (StringUtils.isNotEmpty(organInfo.getName())){
			dc.add(Restrictions.like("name", "%"+organInfo.getName()+"%"));
		}
		if (StringUtils.isNotEmpty(organInfo.getRemarks())){
			dc.add(Restrictions.like("remarks", "%"+organInfo.getRemarks()+"%"));
		}
		dc.add(Restrictions.eq("delFlag", OrganInfo.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return organInfoDao.find(page, dc);
	}
	
	@Transactional(readOnly = false)
	public void save(OrganInfo organInfo) {
		organInfoDao.save(organInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		organInfoDao.deleteById(id);
	}
	
}
