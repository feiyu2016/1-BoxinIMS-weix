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
import com.boxin.ims.modules.momarketing.entity.Terminal;
import com.boxin.ims.modules.momarketing.dao.TerminalDao;

/**
 * 手动终端Service
 * @author Jakemanse
 * @version 2013-05-28
 */
@Component
@Transactional(readOnly = true)
public class TerminalService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(TerminalService.class);
	
	@Autowired
	private TerminalDao terminalDao;
	
	public Terminal get(Long id) {
		return terminalDao.findOne(id);
	}
	
	public Page<Terminal> find(Page<Terminal> page, Terminal terminal) {
		DetachedCriteria dc = terminalDao.createDetachedCriteria();
		if (terminal.getUser()!=null && terminal.getUser().getId()>0){
			dc.add(Restrictions.eq("user.id", terminal.getUser().getId()));
		}
		if (StringUtils.isNotEmpty(terminal.getName())){
			dc.add(Restrictions.like("name", "%"+terminal.getName()+"%"));
		}
		if (StringUtils.isNotEmpty(terminal.getRemarks())){
			dc.add(Restrictions.like("remarks", "%"+terminal.getRemarks()+"%"));
		}
		dc.add(Restrictions.eq("delFlag", Terminal.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return terminalDao.find(page, dc);
	}
	
	@Transactional(readOnly = false)
	public void save(Terminal terminal) {
		terminalDao.save(terminal);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		terminalDao.deleteById(id);
	}
	
}
