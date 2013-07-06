/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.wechat.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.thinkgem.jeesite.common.persistence.BaseDao;
import com.thinkgem.jeesite.common.persistence.BaseDaoImpl;
import com.boxin.ims.modules.wechat.entity.Product;

/**
 * 产品DAO接口
 * @author Jakemanse
 * @version 2013-06-28
 */
public interface ProductDao extends ProductDaoCustom, CrudRepository<Product, Long> {

	@Modifying
	@Query("update Product set delFlag='" + Product.DEL_FLAG_DELETE + "' where id = ?1")
	public int deleteById(Long id);
	
}

/**
 * DAO自定义接口
 * @author Jakemanse
 */
interface ProductDaoCustom extends BaseDao<Product> {

}

/**
 * DAO自定义接口实现
 * @author Jakemanse
 */
@Component
class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDaoCustom {

}
