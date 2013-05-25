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
import com.boxin.ims.modules.momarketing.entity.Device;
import com.boxin.ims.modules.momarketing.dao.DeviceDao;

/**
 * 终端设备Service
 * @author Jakemanse
 * @version 2013-05-25
 */
@Component
@Transactional(readOnly = true)
public class DeviceService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(DeviceService.class);
	
	@Autowired
	private DeviceDao deviceDao;
	
	public Device get(Long id) {
		return deviceDao.findOne(id);
	}
	
	public Page<Device> find(Page<Device> page, Device device) {
		DetachedCriteria dc = deviceDao.createDetachedCriteria();
		if (device.getUser()!=null && device.getUser().getId()>0){
			dc.add(Restrictions.eq("user.id", device.getUser().getId()));
		}
		if (StringUtils.isNotEmpty(device.getName())){
			dc.add(Restrictions.like("name", "%"+device.getName()+"%"));
		}
		if (StringUtils.isNotEmpty(device.getRemarks())){
			dc.add(Restrictions.like("remarks", "%"+device.getRemarks()+"%"));
		}
		dc.add(Restrictions.eq("delFlag", Device.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return deviceDao.find(page, dc);
	}
	
	@Transactional(readOnly = false)
	public void save(Device device) {
		deviceDao.save(device);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		deviceDao.deleteById(id);
	}
	
}
