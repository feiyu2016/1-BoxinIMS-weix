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
import com.boxin.ims.modules.momarketing.entity.GuestBook;

/**
 * 留言DAO接口
 * @author Jakemanse
 * @version 2013-05-28
 */
public interface GuestBookDao extends GuestBookDaoCustom, CrudRepository<GuestBook, Long> {

	@Modifying
	@Query("update GuestBook set delFlag='" + GuestBook.DEL_FLAG_DELETE + "' where id = ?1")
	public int deleteById(Long id);
	
}

/**
 * DAO自定义接口
 * @author Jakemanse
 */
interface GuestBookDaoCustom extends BaseDao<GuestBook> {

}

/**
 * DAO自定义接口实现
 * @author Jakemanse
 */
@Component
class GuestBookDaoImpl extends BaseDaoImpl<GuestBook> implements GuestBookDaoCustom {

}
