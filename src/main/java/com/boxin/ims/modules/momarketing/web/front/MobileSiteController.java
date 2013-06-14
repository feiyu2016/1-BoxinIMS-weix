package com.boxin.ims.modules.momarketing.web.front;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.druid.util.StringUtils;
import com.boxin.framework.base.dao.DaoHelper;
import com.boxin.ims.modules.momarketing.entity.Project;
import com.boxin.ims.modules.momarketing.entity.ProjectVisit;
import com.boxin.ims.modules.momarketing.entity.QRCode;
import com.boxin.ims.modules.momarketing.service.ProjectService;
import com.boxin.ims.modules.momarketing.service.ProjectVisitService;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.BaseEntity;
import com.thinkgem.jeesite.common.web.BaseController;

@Controller
@RequestMapping(value= Global.MOBILE_SITE_PATH + "/mom")
public class MobileSiteController extends BaseController {
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	private DaoHelper daoHelper;
	
	@Autowired
	private ProjectVisitService projectVisitService;
	
	@RequestMapping(value = "pro/{id}" + Global.URL_SUFFIX)
	public String viewSite(@PathVariable Long id,HttpServletRequest request,HttpServletResponse response){
		
		String menuId = request.getParameter("menuId");
		if(StringUtils.isEmpty(menuId)){
			menuId = "1";
		}
		
		//保存访问 信息
		System.out.println("ok........");
		Project project = projectService.get(id);
		
		QRCode qrCode = project.getQrCode();
		
		ProjectVisit pv = new ProjectVisit();
		pv.setProject(project);
		pv.setBrowser(request.getHeader("user-agent"));
		pv.setIp(request.getRemoteHost());
		pv.setMobile(request.getParameter("mobile"));
		pv.setQq(request.getParameter("qq"));
		pv.setMenuId(Long.parseLong(menuId));
		
		projectVisitService.save(pv);
		
		//判断是否失效
		if(BaseEntity.DEL_FLAG_DELETE.equals(project.getDelFlag())){
			request.setAttribute("errorInfo", "您访问的页面已过期!");
			return "modules/ims/front/mobile/mobile";
		}
		
		request.setAttribute("project", project);
		request.setAttribute("qrCode", qrCode);
		
		//处理导航
		List<Map<String,Object>> projectMenus = daoHelper.queryForList("com.boxin.ims.mom.selectProjectMenus", id);
		
		//设置显示标题
		for(Map map:projectMenus){
			if( map.get("id").toString().equals(menuId)){
				request.setAttribute("menuName", map.get("name"));
			}
		}
		
		request.setAttribute("menus", projectMenus);
		
		return "modules/ims/front/mobile/mobile";
	}


}
