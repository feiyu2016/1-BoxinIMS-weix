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

import com.boxin.ims.modules.wechat.dao.RegionDao;
import com.boxin.ims.modules.wechat.entity.Region;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.BaseService;

/**
 * 天气预报的区域码表Service
 * @author Jakemanse
 * @version 2013-06-17
 */
@Component
@Transactional(readOnly = true)
public class RegionService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(RegionService.class);
	
	@Autowired
	private RegionDao regionDao;
	
	public Region get(Long id) {
		return regionDao.findOne(id);
	}
	
	public List<Region> find(Region region){
		DetachedCriteria dc = regionDao.createDetachedCriteria();
		if (StringUtils.isNotEmpty(region.getName())){
			dc.add(Restrictions.like("name", "%"+region.getName()+"%"));
		}
		if (StringUtils.isNotEmpty(region.getCode())){
			dc.add(Restrictions.eq("code", region.getCode()));
		}
		dc.addOrder(Order.desc("id"));
		return regionDao.find(dc);
	}
	
	public Page<Region> find(Page<Region> page, Region region) {
		DetachedCriteria dc = regionDao.createDetachedCriteria();
		if (StringUtils.isNotEmpty(region.getName())){
			dc.add(Restrictions.like("name", "%"+region.getName()+"%"));
		}
		if (StringUtils.isNotEmpty(region.getCode())){
			dc.add(Restrictions.eq("code", region.getCode()));
		}
		dc.add(Restrictions.eq("delFlag", Region.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return regionDao.find(page, dc);
	}
	
	@Transactional(readOnly = false)
	public void save(Region region) {
		regionDao.save(region);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		regionDao.deleteById(id);
	}
	
}
