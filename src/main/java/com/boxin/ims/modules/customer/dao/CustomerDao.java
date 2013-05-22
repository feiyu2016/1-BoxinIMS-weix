package com.boxin.ims.modules.customer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boxin.ims.modules.customer.entity.Customer;
import com.thinkgem.jeesite.common.persistence.BaseDao;
import com.thinkgem.jeesite.common.persistence.BaseDaoImpl;
import com.thinkgem.jeesite.modules.sys.entity.Office;

public interface CustomerDao extends CustomerDaoCustom, CrudRepository<Customer, Long> {
	
	
	@Modifying
	@Query("update Customer set delFlag='" + Office.DEL_FLAG_DELETE + "' where id = ?1 or parentIds like ?2")
	public int deleteById(Long id, String likeParentIds);
	

	@Query("from Customer ")
	public List<Customer> findAllList();
	
	

}


interface CustomerDaoCustom extends  BaseDao<Customer> {
	
}



/**
 * DAO自定义接口实现
 * @author ThinkGem
 */
@Repository
class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDaoCustom {

}