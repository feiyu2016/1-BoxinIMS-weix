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
import com.boxin.ims.modules.momarketing.entity.Coupon;
import com.boxin.ims.modules.momarketing.dao.CouponDao;

/**
 * 优惠券Service
 * @author Jakemanse
 * @version 2013-05-25
 */
@Component
@Transactional(readOnly = true)
public class CouponService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(CouponService.class);
	
	@Autowired
	private CouponDao couponDao;
	
	public Coupon get(Long id) {
		return couponDao.findOne(id);
	}
	
	public Page<Coupon> find(Page<Coupon> page, Coupon coupon) {
		DetachedCriteria dc = couponDao.createDetachedCriteria();
		if (StringUtils.isNotEmpty(coupon.getName())){
			dc.add(Restrictions.like("name", "%"+coupon.getName()+"%"));
		}
		if (StringUtils.isNotEmpty(coupon.getRemarks())){
			dc.add(Restrictions.like("remarks", "%"+coupon.getRemarks()+"%"));
		}
		dc.add(Restrictions.eq("delFlag", Coupon.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return couponDao.find(page, dc);
	}
	
	@Transactional(readOnly = false)
	public void save(Coupon coupon) {
		couponDao.save(coupon);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		couponDao.deleteById(id);
	}
	
}
