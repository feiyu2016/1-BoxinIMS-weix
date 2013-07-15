/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.product.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.thinkgem.jeesite.common.persistence.BaseDao;
import com.thinkgem.jeesite.common.persistence.BaseDaoImpl;
import com.boxin.ims.modules.product.entity.ProductItem;

/**
 * 产品DAO接口
 * @author xuxiang
 * @version 2013-05-20
 */
public interface ProductItemDao extends ProductItemDaoCustom, CrudRepository<ProductItem, Long> {

	@Modifying
	@Query("update ProductItem set delFlag='" + ProductItem.DEL_FLAG_DELETE + "' where id = ?1")
	public int deleteById(Long id);
	
}

/**
 * DAO自定义接口
 * @author xuxiang
 */
interface ProductItemDaoCustom extends BaseDao<ProductItem> {

}

/**
 * DAO自定义接口实现
 * @author xuxiang
 */
@Component
class ProductItemDaoImpl extends BaseDaoImpl<ProductItem> implements ProductItemDaoCustom {

}
