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
import com.boxin.ims.modules.momarketing.entity.QRCode;
import com.boxin.ims.modules.momarketing.dao.QrCodeDao;

/**
 * 二维码Service
 * @author Jakemanse
 * @version 2013-05-27
 */
@Component
@Transactional(readOnly = true)
public class QrCodeService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(QrCodeService.class);
	
	@Autowired
	private QrCodeDao qrCodeDao;
	
	public QRCode get(Long id) {
		return qrCodeDao.findOne(id);
	}
	
	public Page<QRCode> find(Page<QRCode> page, QRCode qrCode) {
		DetachedCriteria dc = qrCodeDao.createDetachedCriteria();
		if (StringUtils.isNotEmpty(qrCode.getContent())){
			dc.add(Restrictions.like("remarks", "%"+qrCode.getContent()+"%"));
		}
		dc.add(Restrictions.eq("delFlag", QRCode.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return qrCodeDao.find(page, dc);
	}
	
	@Transactional(readOnly = false)
	public void save(QRCode qrCode) {
		qrCodeDao.save(qrCode);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		qrCodeDao.deleteById(id);
	}
	
}
