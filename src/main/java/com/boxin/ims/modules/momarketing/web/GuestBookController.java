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
import com.boxin.ims.modules.momarketing.entity.GuestBook;
import com.boxin.ims.modules.momarketing.service.GuestBookService;

/**
 * 留言Controller
 * @author Jakemanse
 * @version 2013-05-28
 */
@Controller
@RequestMapping(value = Global.MOBILE_SITE_PATH+"/mom/guestBook")
public class GuestBookController extends BaseController {

	@Autowired
	private GuestBookService guestBookService;
	
	@ModelAttribute
	public GuestBook get(@RequestParam(required=false) Long id) {
		if (id != null){
			return guestBookService.get(id);
		}else{
			return new GuestBook();
		}
	}
	
	@RequiresPermissions("momarketing:guestBook:view")
	@RequestMapping(value = {"list", ""})
	public String list(GuestBook guestBook, HttpServletRequest request, HttpServletResponse response, Model model) {
		
        Page<GuestBook> page = guestBookService.find(new Page<GuestBook>(request, response), guestBook); 
        model.addAttribute("page", page);
		return "modules/momarketing/guestBookList";
	}

	//@RequiresPermissions("momarketing:guestBook:view")
	@RequestMapping(value = "form")
	public String form(GuestBook guestBook, Model model) {
		model.addAttribute("guestBook", guestBook);
		return "modules/momarketing/guestBookForm";
	}

	@RequiresPermissions("momarketing:guestBook:edit")
	@RequestMapping(value = "save")
	public String save(GuestBook guestBook, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, guestBook)){
			return form(guestBook, model);
		}
		guestBookService.save(guestBook);
		addMessage(redirectAttributes, "保存留言'" + guestBook.getProject().getName() + "'成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/momarketing/guestBook/?repage";
	}
	
	@RequiresPermissions("momarketing:guestBook:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		guestBookService.delete(id);
		addMessage(redirectAttributes, "删除留言成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/momarketing/guestBook/?repage";
	}

}
