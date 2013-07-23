/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.momarketing.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.thinkgem.jeesite.common.persistence.BaseDao;
import com.thinkgem.jeesite.common.persistence.BaseDaoImpl;
import com.boxin.ims.modules.momarketing.entity.Coupon;

/**
 * 优惠券DAO接口
 * @author Jakemanse
 * @version 2013-05-25
 */
public interface CouponDao extends CouponDaoCustom, CrudRepository<Coupon, Long> {

	@Modifying
	@Query("update Coupon set delFlag='" + Coupon.DEL_FLAG_DELETE + "' where id = ?1")
	public int deleteById(Long id);
	
	@Modifying
	@Query("update Coupon set delFlag='" + Coupon.DEL_FLAG_DELETE + "',status='"+Coupon.CANCEL_FLAG_DELETE+"' where id = ?1")
	public int cancelById(Long id);
	
}

/**
 * DAO自定义接口
 * @author Jakemanse
 */
interface CouponDaoCustom extends BaseDao<Coupon> {

}

/**
 * DAO自定义接口实现
 * @author Jakemanse
 */
@Component
class CouponDaoImpl extends BaseDaoImpl<Coupon> implements CouponDaoCustom {

}
