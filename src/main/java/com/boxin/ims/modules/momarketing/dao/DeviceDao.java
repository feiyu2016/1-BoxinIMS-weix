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
import com.boxin.ims.modules.momarketing.entity.Device;

/**
 * 终端设备DAO接口
 * @author Jakemanse
 * @version 2013-05-25
 */
public interface DeviceDao extends DeviceDaoCustom, CrudRepository<Device, Long> {

	@Modifying
	@Query("update Device set delFlag='" + Device.DEL_FLAG_DELETE + "' where id = ?1")
	public int deleteById(Long id);
	
}

/**
 * DAO自定义接口
 * @author Jakemanse
 */
interface DeviceDaoCustom extends BaseDao<Device> {

}

/**
 * DAO自定义接口实现
 * @author Jakemanse
 */
@Component
class DeviceDaoImpl extends BaseDaoImpl<Device> implements DeviceDaoCustom {

}
