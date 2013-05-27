/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.momarketing.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.boxin.ims.modules.momarketing.entity.QRCode;
import com.boxin.ims.modules.momarketing.service.QrCodeService;

/**
 * 二维码Controller
 * @author Jakemanse
 * @version 2013-05-27
 */
@Controller
@RequestMapping(value = Global.ADMIN_PATH+"/momarketing/qrCode")
public class QrCodeController extends BaseController {

	@Autowired
	private QrCodeService qrCodeService;
	
	@ModelAttribute
	public QRCode get(@RequestParam(required=false) Long id) {
		if (id != null){
			return qrCodeService.get(id);
		}else{
			return new QRCode();
		}
	}
	
	@RequiresPermissions("momarketing:qrCode:view")
	@RequestMapping(value = {"list", ""})
	public String list(QRCode qrCode, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<QRCode> page = qrCodeService.find(new Page<QRCode>(request, response), qrCode); 
        model.addAttribute("page", page);
		return "modules/momarketing/qrCodeList";
	}

	@RequiresPermissions("momarketing:qrCode:view")
	@RequestMapping(value = "form")
	public String form(QRCode qrCode, Model model) {
		model.addAttribute("qrCode", qrCode);
		return "modules/momarketing/qrCodeForm";
	}

	@RequiresPermissions("momarketing:qrCode:edit")
	@RequestMapping(value = "save")
	public String save(QRCode qrCode, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, qrCode)){
			return form(qrCode, model);
		}
		qrCodeService.save(qrCode);
		addMessage(redirectAttributes, "保存二维码'" + qrCode.getId() + "'成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/momarketing/qrCode/?repage";
	}
	
	@RequiresPermissions("momarketing:qrCode:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		qrCodeService.delete(id);
		addMessage(redirectAttributes, "删除二维码成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/momarketing/qrCode/?repage";
	}

}
