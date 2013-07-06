/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.wechat.web;

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
import com.boxin.ims.modules.wechat.entity.Product;
import com.boxin.ims.modules.wechat.service.ProductService;

/**
 * 产品Controller
 * @author Jakemanse
 * @version 2013-06-28
 */
@Controller
@RequestMapping(value = Global.ADMIN_PATH+"/wechat/product")
public class ProductController extends BaseController {

	@Autowired
	private ProductService productService;
	
	@ModelAttribute
	public Product get(@RequestParam(required=false) Long id) {
		if (id != null){
			return productService.get(id);
		}else{
			return new Product();
		}
	}
	
	@RequiresPermissions("wechat:product:view")
	@RequestMapping(value = {"list", ""})
	public String list(Product product, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		if (!user.isAdmin()){
			product.setUser(user);
		}
        Page<Product> page = productService.find(new Page<Product>(request, response), product); 
        model.addAttribute("page", page);
		return "modules/wechat/productList";
	}

	@RequiresPermissions("wechat:product:view")
	@RequestMapping(value = "form")
	public String form(Product product, Model model) {
		
		User user = UserUtils.getUser();
		product.setUser(user);
		
		model.addAttribute("product", product);
		return "modules/wechat/productForm";
	}

	@RequiresPermissions("wechat:product:edit")
	@RequestMapping(value = "save")
	public String save(Product product, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, product)){
			return form(product, model);
		}
		productService.save(product);
		addMessage(redirectAttributes, "保存产品'" + product.getName() + "'成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/wechat/product/?repage";
	}
	
	@RequiresPermissions("wechat:product:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		productService.delete(id);
		addMessage(redirectAttributes, "删除产品成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/wechat/product/?repage";
	}

}
