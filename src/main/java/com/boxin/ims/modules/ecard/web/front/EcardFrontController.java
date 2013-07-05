/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.ecard.web.front;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boxin.ims.modules.ecard.entity.Ecard;
import com.boxin.ims.modules.ecard.service.EcardService;
import com.boxin.ims.modules.momarketing.common.ProjectUtils;
import com.boxin.ims.modules.momarketing.entity.QRCode;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

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
		
		String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getLocalAddr() + ":"
                                   + request.getServerPort() + path ;
        
        String url = basePath  + Global.MOBILE_ECARD_PATH +"/view-"+ecard.getId()+Global.URL_SUFFIX;
        request.setAttribute("url", url);
		
		return "modules/ecard/front/ecard";
	}
	
	/**
	 * @author Jakemanse
	 * @time 2013-7-1  下午3:32:28
	 * @function <p>  </p>
	 * @param id
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = {"/view-{id}"+ Global.URL_SUFFIX, ""})
	public void viewEcardLogo(@PathVariable Long id,HttpServletRequest req,HttpServletResponse response) throws Exception{
		
		
		Ecard ecard = 	ecardService.get(id);
		
		String filepath = ecard.getLogo();
		File file = new File(filepath);
		
		BufferedImage image = 	ImageIO.read(file);
		
		OutputStream out = response.getOutputStream();
		ImageIO.write(image, "JPEG", out);
		out.flush();
		out.close();
	}


}
