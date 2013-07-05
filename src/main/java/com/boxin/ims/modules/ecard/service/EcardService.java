/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.ecard.service;

import javax.servlet.http.HttpServletRequest;

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
import com.boxin.ims.modules.ecard.entity.Ecard;
import com.boxin.ims.modules.ecard.dao.EcardDao;
import com.boxin.ims.modules.momarketing.common.QRCodeUtils;
import com.boxin.ims.modules.momarketing.dao.QRCodeDao;
import com.boxin.ims.modules.momarketing.entity.Project;
import com.boxin.ims.modules.momarketing.entity.QRCode;

/**
 * 公司活动Service
 * @author Jakemanse
 * @version 2013-06-10
 */
@Component
@Transactional(readOnly = true)
public class EcardService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(EcardService.class);
	
	@Autowired
	private EcardDao ecardDao;
	
	@Autowired
	private QRCodeDao QRCodeDao;
	
	public Ecard get(Long id) {
		return ecardDao.findOne(id);
	}
	
	public Page<Ecard> find(Page<Ecard> page, Ecard ecard) {
		DetachedCriteria dc = ecardDao.createDetachedCriteria();
		if (ecard.getUser()!=null && ecard.getUser().getId()>0){
			dc.add(Restrictions.eq("user.id", ecard.getUser().getId()));
		}
		if (StringUtils.isNotEmpty(ecard.getName())){
			dc.add(Restrictions.like("name", "%"+ecard.getName()+"%"));
		}
		if (StringUtils.isNotEmpty(ecard.getRemarks())){
			dc.add(Restrictions.like("remarks", "%"+ecard.getRemarks()+"%"));
		}
		dc.add(Restrictions.eq("delFlag", Ecard.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return ecardDao.find(page, dc);
	}
	
	@Transactional(readOnly = false)
	public void save(Ecard ecard,HttpServletRequest request) {
		
		QRCode qrCode = new QRCode();
		qrCode.setContent("None");
		
		QRCode savedqrCode = QRCodeDao.save(qrCode);
		
		String qrPath = Constants.getEcardQRCodeResourceSavePath();
		qrCode.setJpegPath(qrPath +savedqrCode.getId());
		ecard.setQrCode(savedqrCode);
		Ecard  savedEcard = ecardDao.save(ecard);
		
		String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getLocalAddr() + ":"
                                   + request.getServerPort() + path ;
		
		String con = QRCodeUtils.generateEcardURL(basePath,savedEcard.getId());
		qrCode.setContent(con);
		QRCodeUtils.generateQRCodeJPEG(qrCode.getContent(), qrCode.getJpegPath(), 200, 200);
		QRCodeDao.save(qrCode);
		
		
		
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		ecardDao.deleteById(id);
	}
	
}
