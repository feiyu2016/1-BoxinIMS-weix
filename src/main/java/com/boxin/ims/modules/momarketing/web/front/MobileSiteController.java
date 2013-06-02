package com.boxin.ims.modules.momarketing.web.front;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boxin.ims.modules.momarketing.entity.Project;
import com.boxin.ims.modules.momarketing.entity.ProjectVisit;
import com.boxin.ims.modules.momarketing.entity.QRCode;
import com.boxin.ims.modules.momarketing.service.ProjectService;
import com.boxin.ims.modules.momarketing.service.ProjectVisitService;
import com.boxin.ims.modules.momarketing.service.QRCodeService;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.web.BaseController;

@Controller
@RequestMapping(value= Global.MOBILE_SITE_PATH + "/mom")
public class MobileSiteController extends BaseController {
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	QRCodeService QRCodeService;
	@Autowired
	private ProjectVisitService projectVisitService;
	
	@RequestMapping(value = "pro/{id}" + Global.URL_SUFFIX)
	public String viewSite(@PathVariable Long id,HttpServletRequest request,HttpServletResponse response){
		
		request.getRemoteAddr();
		
		
		
		
		System.out.println("ok........");
		Project project = projectService.get(id);
		QRCode qrCode = project.getQrCode();
		
		ProjectVisit pv = new ProjectVisit();
		pv.setProject(project);
		pv.setBrowser(request.getHeader("user-agent"));
		pv.setIp(request.getRemoteHost());
		pv.setMobile(request.getParameter("mobile"));
		pv.setQq(request.getParameter("qq"));
		
		projectVisitService.save(pv);	
		
		request.setAttribute("project", project);
		request.setAttribute("qrCode", qrCode);
		return "modules/ims/front/mobile/mobile";
	}


}
