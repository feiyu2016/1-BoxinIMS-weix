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

import com.boxin.ims.modules.momarketing.common.QRCodeUtils;
import com.boxin.ims.modules.momarketing.dao.ProjectDao;
import com.boxin.ims.modules.momarketing.dao.QRCodeDao;
import com.boxin.ims.modules.momarketing.entity.Project;
import com.boxin.ims.modules.momarketing.entity.QRCode;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.BaseService;

/**
 * 移动营销项目Service
 * @author Jakemanse
 * @version 2013-05-25
 */
@Component
@Transactional(readOnly = true)
public class ProjectService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(ProjectService.class);
	
	@Autowired
	private ProjectDao projectDao;

	@Autowired
	private QRCodeDao QRCodeDao;
	
	
	public Project get(Long id) {
		return projectDao.findOne(id);
	}
	
	public Page<Project> find(Page<Project> page, Project project) {
		DetachedCriteria dc = projectDao.createDetachedCriteria();
		if (project.getUser()!=null && project.getUser().getId()>0){
			dc.add(Restrictions.eq("user.id", project.getUser().getId()));
		}
		if (StringUtils.isNotEmpty(project.getName())){
			dc.add(Restrictions.like("name", "%"+project.getName()+"%"));
		}
		if (StringUtils.isNotEmpty(project.getRemarks())){
			dc.add(Restrictions.like("remarks", "%"+project.getRemarks()+"%"));
		}
		dc.add(Restrictions.eq("delFlag", Project.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return projectDao.find(page, dc);
	}
	
	@Transactional(readOnly = false)
	public void save(Project project) {
		
		//生成二维码
		QRCode qrCode = new QRCode();
		qrCode.setContent("None");
		qrCode.setJpegPath(Global.QRCODE_REPOSITORY+System.currentTimeMillis());
		
		QRCode savedqrCode = QRCodeDao.save(qrCode);
		
		
		project.setQrCode(savedqrCode);
		Project savedProject = projectDao.save(project);
		String con = QRCodeUtils.generateURL(savedProject.getId());
		qrCode.setContent(con);
		QRCodeUtils.generateQRCodeJPEG(qrCode.getContent(), qrCode.getJpegPath(), 200, 200);
		QRCodeDao.save(qrCode);
				
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		projectDao.deleteById(id);
	}
	
}
