package com.boxin.ims.modules.momarketing.web.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.web.BaseController;

@Controller
@RequestMapping(value= Global.MOBILE_SITE_PATH + "/mom")
public class MobileSiteController extends BaseController {
	
	@RequestMapping(value = "pro/{id}" + Global.URL_SUFFIX)
	public String viewSite(@PathVariable Long id){
		
		System.out.println("ok........");
		
		 return "modules/ims/front/mobile/mobile";
	}


}
