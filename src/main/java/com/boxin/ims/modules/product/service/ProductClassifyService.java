/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.product.service;

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

import com.boxin.ims.modules.product.dao.ProductClassifyDao;
import com.boxin.ims.modules.product.entity.ProductClassify;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.BaseService;
import com.thinkgem.jeesite.modules.sys.dao.UserDao;
import com.thinkgem.jeesite.modules.sys.entity.User;

/**
 * 产品Service
 * @author xuxiang
 * @version 2013-05-20
 */
@Component
@Transactional(readOnly = true)
public class ProductClassifyService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(ProductClassifyService.class);

	@Autowired
	private ProductClassifyDao productClassifyDao;

	public ProductClassify get(Long id) {
		return productClassifyDao.findOne(id);
	}

	public List<ProductClassify> find(User user) {
		DetachedCriteria dc = productClassifyDao.createDetachedCriteria();
		if(user != null && user.getId() > 0){
			dc.add(Restrictions.eq("user.id", user.getId()));
		}
		dc.add(Restrictions.eq("delFlag", "0"));
		dc.addOrder(Order.desc("createDate"));
		return productClassifyDao.find(dc);
	}
	public Page<ProductClassify> find(Page<ProductClassify> page, ProductClassify productClassify) {
		DetachedCriteria dc = productClassifyDao.createDetachedCriteria();
		if (productClassify.getUser()!=null && productClassify.getUser().getId()>0){
			dc.add(Restrictions.eq("user.id", productClassify.getUser().getId()));
		}
		if (StringUtils.isNotEmpty(productClassify.getName())){
			dc.add(Restrictions.like("name", "%"+productClassify.getName()+"%"));
		}

		dc.add(Restrictions.eq("delFlag", ProductClassify.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return productClassifyDao.find(page, dc);
	}

	@Transactional(readOnly = false)
	public void save(ProductClassify productClassify) {
//		if(productClassify.getId() != null){
//			productClassifyDao.getSession().update(productClassify);			
//		}else{
			productClassifyDao.save(productClassify);			
//		}
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		productClassifyDao.delete(id);
	}

}
