/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.ecard.web.front;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.boxin.ims.modules.ecard.entity.Ecard;
import com.boxin.ims.modules.ecard.service.EcardService;

/**
 * 公司活动Controller
 * @author Jakemanse
 * @version 2013-06-10
 */
@Controller
@RequestMapping(value= Global.MOBILE_ECARD_PATH )
public class EcardFrontController extends BaseController {

	@Autowired
	private EcardService ecardService;
	
	
	@RequestMapping(value = {"/{id}"+ Global.URL_SUFFIX, ""})
	public String viewEcard(@PathVariable Long id,HttpServletRequest request,HttpServletResponse response) {
		User user = UserUtils.getUser();
		Ecard ecard = 	ecardService.get(id);
        //Page<Ecard> page = ecardService.find(new Page<Ecard>(request, response), ecard); 
        //model.addAttribute("page", page);
		request.setAttribute("ecard", ecard);
		
		return "modules/ecard/front/ecard";
	}


}
