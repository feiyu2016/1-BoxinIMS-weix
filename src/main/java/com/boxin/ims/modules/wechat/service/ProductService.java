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

import com.boxin.ims.modules.wechat.dao.ProductDao;
import com.boxin.ims.modules.wechat.entity.Product;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.BaseService;

/**
 * 产品Service
 * @author Jakemanse
 * @version 2013-06-28
 */
@Component
@Transactional(readOnly = true)
public class ProductService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(ProductService.class);
	
	@Autowired
	private ProductDao productDao;
	
	public Product get(Long id) {
		return productDao.findOne(id);
	}
	
	public Page<Product> find(Page<Product> page, Product product) {
		DetachedCriteria dc = productDao.createDetachedCriteria();
		if (product.getUser()!=null && product.getUser().getId()>0){
			dc.add(Restrictions.eq("user.id", product.getUser().getId()));
		}else{
			
		}
		if (StringUtils.isNotEmpty(product.getName())){
			dc.add(Restrictions.like("name", "%"+product.getName()+"%"));
		}
		if (StringUtils.isNotEmpty(product.getDescription())){
			dc.add(Restrictions.like("description", "%"+product.getDescription()+"%"));
		}
		dc.add(Restrictions.eq("delFlag", Product.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return productDao.find(page, dc);
	}
	public List<Product> find(Product product) {
		DetachedCriteria dc = productDao.createDetachedCriteria();
		if (product.getUser()!=null && product.getUser().getId()>0){
			dc.add(Restrictions.eq("user.id", product.getUser().getId()));
		}else{
			dc.add(Restrictions.eq("user.id", -1L));
		}
		if (StringUtils.isNotEmpty(product.getName())){
			dc.add(Restrictions.like("name", "%"+product.getName()+"%"));
		}
		if (StringUtils.isNotEmpty(product.getDescription())){
			dc.add(Restrictions.like("description", "%"+product.getDescription()+"%"));
		}
		dc.add(Restrictions.eq("delFlag", Product.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		return productDao.find( dc);
	}
	
	
	
	@Transactional(readOnly = false)
	public void save(Product product) {
		productDao.save(product);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		productDao.deleteById(id);
	}
	
}
