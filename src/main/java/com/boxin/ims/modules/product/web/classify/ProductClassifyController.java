/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.product.web.classify;

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
import com.boxin.ims.modules.product.entity.classify.ProductClassify;
import com.boxin.ims.modules.product.service.classify.ProductClassifyService;
import com.boxin.ims.modules.product.service.item.ProductItemService;

/**
 * 产品Controller
 * @author xuxiang
 * @version 2013-05-20
 */
@Controller
@RequestMapping(value = Global.ADMIN_PATH+"/product/classify/productClassify")
public class ProductClassifyController extends BaseController {

	@Autowired
	private ProductClassifyService productClassifyService;
	@Autowired
	private ProductItemService productItemService;
	
	@ModelAttribute
	public ProductClassify get(@RequestParam(required=false) Long id) {
		if (id != null){
			return productClassifyService.get(id);
		}else{
			return new ProductClassify();
		}
	}
	
	@RequiresPermissions("product:classify:productClassify:view")
	@RequestMapping(value = {"list", ""})
	public String list(ProductClassify productClassify, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		if (!user.isAdmin()){
			productClassify.setUser(user);
		}
        Page<ProductClassify> page = productClassifyService.find(new Page<ProductClassify>(request, response), productClassify); 
        model.addAttribute("page", page);
		return "modules/product/classify/productClassifyList";
	}

	@RequiresPermissions("product:classify:productClassify:view")
	@RequestMapping(value = "form")
	public String form(ProductClassify productClassify, Model model) {
		model.addAttribute("productClassify", productClassify);
		return "modules/product/classify/productClassifyForm";
	}

	@RequiresPermissions("product:classify:productClassify:edit")
	@RequestMapping(value = "save")
	public String save(ProductClassify productClassify, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, productClassify)){
			return form(productClassify, model);
		}
		productClassifyService.save(productClassify);
		addMessage(redirectAttributes, "保存产品'" + productClassify.getName() + "'成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/product/classify/productClassify/?repage";
	}
	
	@RequiresPermissions("product:classify:productClassify:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		productClassifyService.delete(id);
		addMessage(redirectAttributes, "删除产品成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/product/classify/productClassify/?repage";
	}

}
