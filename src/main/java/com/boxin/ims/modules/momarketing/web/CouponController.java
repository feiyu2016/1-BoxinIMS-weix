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
import com.boxin.ims.modules.momarketing.entity.Coupon;
import com.boxin.ims.modules.momarketing.service.CouponService;

/**
 * 优惠券Controller
 * @author Jakemanse
 * @version 2013-05-25
 */
@Controller
@RequestMapping(value = Global.ADMIN_PATH+"/mom/coupon")
public class CouponController extends BaseController {

	@Autowired
	private CouponService couponService;
	
	@ModelAttribute
	public Coupon get(@RequestParam(required=false) Long id) {
		if (id != null){
			return couponService.get(id);
		}else{
			return new Coupon();
		}
	}
	
	@RequiresPermissions("momarketing:coupon:view")
	@RequestMapping(value = {"list", ""})
	public String list(Coupon coupon, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
//		if (!user.isAdmin()){
//			coupon.setUser(user);
//		}
        Page<Coupon> page = couponService.find(new Page<Coupon>(request, response), coupon); 
        model.addAttribute("page", page);
		return "modules/momarketing/couponList";
	}

	@RequiresPermissions("momarketing:coupon:view")
	@RequestMapping(value = "form")
	public String form(Coupon coupon, Model model) {
		model.addAttribute("coupon", coupon);
		return "modules/momarketing/couponForm";
	}

	@RequiresPermissions("momarketing:coupon:edit")
	@RequestMapping(value = "save")
	public String save(Coupon coupon, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, coupon)){
			return form(coupon, model);
		}
		couponService.save(coupon);
		addMessage(redirectAttributes, "保存优惠券'" + coupon.getName() + "'成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/momarketing/coupon/?repage";
	}
	
	@RequiresPermissions("momarketing:coupon:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		couponService.delete(id);
		addMessage(redirectAttributes, "删除优惠券成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/momarketing/coupon/?repage";
	}

}
