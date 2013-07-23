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

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.BaseService;
import com.boxin.framework.base.utils.Constants;
import com.boxin.ims.modules.momarketing.entity.Coupon;
import com.boxin.ims.modules.momarketing.entity.Project;
import com.boxin.ims.modules.momarketing.entity.QRCode;
import com.boxin.ims.modules.momarketing.common.QRCodeUtils;
import com.boxin.ims.modules.momarketing.dao.CouponDao;
import com.boxin.ims.modules.momarketing.dao.QRCodeDao;

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
	
	
	@Autowired
	private QRCodeDao QRCodeDao;
	
	public Coupon get(Long id) {
		return couponDao.findOne(id);
	}
	
	public Page<Coupon> find(Page<Coupon> page, Coupon coupon) {
		DetachedCriteria dc = couponDao.createDetachedCriteria();
		if(coupon.getUser()!=null && coupon.getUser().getId()!=null){
			if(!coupon.getUser().isAdmin()){
				dc.add(Restrictions.eq("user.id", coupon.getUser().getId()));
			}
		}
		if (StringUtils.isNotEmpty(coupon.getName())){
			dc.add(Restrictions.like("name", "%"+coupon.getName()+"%"));
		}
		if (StringUtils.isNotEmpty(coupon.getNumber())){
			dc.add(Restrictions.like("number", "%"+coupon.getNumber()+"%"));
		}
		if (StringUtils.isNotEmpty(coupon.getMobile())){
			dc.add(Restrictions.like("mobile", "%"+coupon.getMobile()+"%"));
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
		
		
		// 生成二维码
		QRCode qrCode = new QRCode();
		
		String qrPath = Constants.getEcardQRCodeResourceSavePath();
		qrCode.setContent(QRCodeUtils.generateSN(coupon.getUser().getId()));
		qrCode.setJpegPath(qrPath +qrCode.getContent());
		//生成二维码
		QRCodeUtils.generateQRCodeJPEG(qrCode.getContent(),
				qrCode.getJpegPath(), 200, 200);
		
		QRCode savedqrCode = QRCodeDao.save(qrCode);
		coupon.setNumber(qrCode.getContent());
		coupon.setQrCode(savedqrCode);
		
		couponDao.save(coupon);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		couponDao.deleteById(id);
	}
	
	
	@Transactional(readOnly = false)
	public void cancel(Long id) {
		couponDao.cancelById(id);
	}
	
}
