package com.boxin.ims.modules.wechat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boxin.framework.base.dao.DaoHelper;

@Service
public class WechatMybatisService {
	
	@Autowired
	DaoHelper daoHelper;
	
	public int getNewsReplyCountByConfigId(Long id){
		return daoHelper.queryForTotalRow("com.boxin.ims.wechat.getNewsReplyCountByConfigId", id);
	}

}
