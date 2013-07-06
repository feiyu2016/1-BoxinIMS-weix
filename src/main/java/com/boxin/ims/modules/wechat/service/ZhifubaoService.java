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

import com.boxin.ims.modules.wechat.dao.ZhifubaoDao;
import com.boxin.ims.modules.wechat.entity.Zhifubao;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.BaseService;

/**
 * 支付宝帐号信息Service
 * @author Jakemanse
 * @version 2013-06-28
 */
@Component
@Transactional(readOnly = true)
public class ZhifubaoService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(ZhifubaoService.class);
	
	@Autowired
	private ZhifubaoDao zhifubaoDao;
	
	public Zhifubao get(Long id) {
		return zhifubaoDao.findOne(id);
	}
	
	public Page<Zhifubao> find(Page<Zhifubao> page, Zhifubao zhifubao) {
		DetachedCriteria dc = zhifubaoDao.createDetachedCriteria();
		if (zhifubao.getUser()!=null && zhifubao.getUser().getId()>0){
			dc.add(Restrictions.eq("user.id", zhifubao.getUser().getId()));
		}else{
			dc.add(Restrictions.eq("user.id", -1L));
		}
		if (StringUtils.isNotEmpty(zhifubao.getName())){
			dc.add(Restrictions.like("name", "%"+zhifubao.getName()+"%"));
		}
		if (StringUtils.isNotEmpty(zhifubao.getRemarks())){
			dc.add(Restrictions.like("remarks", "%"+zhifubao.getRemarks()+"%"));
		}
		dc.add(Restrictions.eq("delFlag", Zhifubao.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return zhifubaoDao.find(page, dc);
	}
	
	/**
	 * @author Jakemanse
	 * @time 2013-6-28  上午11:17:59
	 * @function <p> 根据用户得到绑定的支付宝 </p>
	 * @param id
	 * @return
	 */
	public Zhifubao getZhifubaoByUserId(Long id){
		DetachedCriteria dc = zhifubaoDao.createDetachedCriteria();
		dc.add(Restrictions.eq("user.id", id));
		dc.addOrder(Order.desc("id"));
		List<Zhifubao> zhifubaoList = zhifubaoDao.find(dc);
		
		return (zhifubaoList==null || zhifubaoList.size() ==0) ? null : zhifubaoList.get(0);
	}
	
	
	@Transactional(readOnly = false)
	public void save(Zhifubao zhifubao) {
		zhifubaoDao.save(zhifubao);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		zhifubaoDao.deleteById(id);
	}
	
}
