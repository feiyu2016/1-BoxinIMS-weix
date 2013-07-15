/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.product.service;

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
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.boxin.ims.modules.product.entity.ProductItem;
import com.boxin.ims.modules.product.dao.ProductItemDao;

/**
 * 产品Service
 * @author xuxiang
 * @version 2013-05-20
 */
@Component
@Transactional(readOnly = true)
public class ProductItemService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(ProductItemService.class);

	@Autowired
	private ProductItemDao productItemDao;

	public ProductItem get(Long id) {
		return productItemDao.findOne(id);
	}

	public Page<ProductItem> find(Page<ProductItem> page, Long type,ProductItem productItem) {
		DetachedCriteria dc = productItemDao.createDetachedCriteria();
		if (StringUtils.isNotEmpty(productItem.getName())){
			dc.add(Restrictions.like("name", "%"+productItem.getName()+"%"));
		}
		if (type != null){
			dc.add(Restrictions.eq("type.id", type));
		}
		dc.add(Restrictions.eq("delFlag", ProductItem.DEL_FLAG_NORMAL));
		dc.addOrder(Order.desc("id"));
		page.setCount(-1);
		return productItemDao.find(page, dc);
	}

	@Transactional(readOnly = false)
	public void save(ProductItem productItem) {
		productItemDao.save(productItem);
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		productItemDao.deleteById(id);
	}

}
