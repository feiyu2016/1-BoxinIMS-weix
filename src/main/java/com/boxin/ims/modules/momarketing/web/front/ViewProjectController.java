package com.boxin.ims.modules.momarketing.web.front;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boxin.framework.base.dao.DaoHelper;
import com.boxin.ims.modules.momarketing.entity.Project;
import com.boxin.ims.modules.momarketing.service.ProjectService;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.web.BaseController;

@Controller
@RequestMapping(value = Global.FRONT_PATH +"/vpc")
public class ViewProjectController extends BaseController{
	
	@Autowired
	private DaoHelper daoHelper;
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value = "vp/{id}" + Global.URL_SUFFIX)
	public String viewProject(@PathVariable Long id,HttpServletRequest request){
		Map<String,Object> params = new HashMap<String,Object>();
		String pid = request.getParameter("pid").toString();
		params.put("pid", pid);
		List<Map<String,Object>> visitList = 	daoHelper.queryForList("com.boxin.ims.mom.selectProjectVisiteStat", params);
		
		
		Project project = 	projectService.get(Long.parseLong(pid));
		
		request.setAttribute("visitList", visitList);	//访问统计列表
		request.setAttribute("qrCode", project.getQrCode());
		
		
		System.out.println("ok........");
		 return "modules/ims/front/viewProject";
	}

}
