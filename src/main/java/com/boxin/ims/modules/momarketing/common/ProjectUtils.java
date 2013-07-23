package com.boxin.ims.modules.momarketing.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.boxin.ims.modules.momarketing.dao.ProjectDao;
import com.boxin.ims.modules.momarketing.entity.Coupon;
import com.boxin.ims.modules.momarketing.entity.QRCode;
import com.boxin.ims.modules.momarketing.service.QRCodeService;


@Service
public class ProjectUtils implements ApplicationContextAware {
	
	private static ProjectDao projectDao;
	
	private static QRCodeService qrCodeService;
	
	
	public static QRCode getQRCodeById(Long id){
		
		return qrCodeService.get(id);
	}
	
	/**
	 * @author Jakemanse
	 * @time 2013-7-24  上午12:14:48
	 * @function <p> 查看优惠券的二维码页面URL </p>
	 * @param couponId
	 * @return
	 */
	public static String getCouponQRCodeURL(Long couponId){
		return Coupon.VIEW_QRCODE_URL_PRIX+couponId;
	}
	
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		
		projectDao = (ProjectDao)applicationContext.getBean("projectDao");
		qrCodeService = (QRCodeService)applicationContext.getBean("QRCodeService");
		
	}

}
