package com.boxin.ims.modules.wechat.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boxin.framework.base.dao.DaoHelper;
import com.boxin.ims.modules.wechat.entity.NewsReply;

@Service
public class WechatMybatisService {
	
	@Autowired
	DaoHelper daoHelper;
	
	public int getNewsReplyCountByConfigId(Long id){
		return daoHelper.queryForTotalRow("com.boxin.ims.wechat.getNewsReplyCountByConfigId", id);
	}
	
	
	/**
	 * @author Jakemanse
	 * @time 2013-6-27  上午12:50:42
	 * @function <p> 查找图文消息 </p>
	 * @param params
	 * @return
	 */
	public List<NewsReply> findNewsReply(Map<String,String> params){
		
		return  daoHelper.queryForList("com.boxin.ims.wechat.selectNewsReplys", params);
	}

}
