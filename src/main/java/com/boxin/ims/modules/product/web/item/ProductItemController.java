/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.boxin.ims.modules.product.web.item;

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
import com.boxin.ims.modules.product.entity.item.ProductItem;
import com.boxin.ims.modules.product.service.item.ProductItemService;

/**
 * 产品Controller
 * @author xuxiang
 * @version 2013-05-20
 */
@Controller
@RequestMapping(value = Global.ADMIN_PATH+"/product/item/productItem")
public class ProductItemController extends BaseController {

	@Autowired
	private ProductItemService productItemService;

	@ModelAttribute
	public ProductItem get(@RequestParam(required=false) Long id) {
		if (id != null){
			return productItemService.get(id);
		}else{
			return new ProductItem();
		}
	}

	@RequiresPermissions("product:item:productItem:view")
	@RequestMapping(value = {"list", ""})
	public String list(ProductItem productItem, HttpServletRequest request, HttpServletResponse response, Model model) {

        Page<ProductItem> page = productItemService.find(new Page<ProductItem>(request, response),1L, productItem);
        model.addAttribute("page", page);
		return "modules/product/item/productItemList";
	}

	@RequiresPermissions("product:item:productItem:view")
	@RequestMapping(value = "form")
	public String form(ProductItem productItem, Model model) {
		model.addAttribute("productItem", productItem);
		return "modules/product/item/productItemForm";
	}

	@RequiresPermissions("product:item:productItem:edit")
	@RequestMapping(value = "save")
	public String save(ProductItem productItem, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, productItem)){
			return form(productItem, model);
		}
		productItemService.save(productItem);
		addMessage(redirectAttributes, "保存产品'" + productItem.getName() + "'成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/product/item/productItem/?repage";
	}

	@RequiresPermissions("product:item:productItem:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		productItemService.delete(id);
		addMessage(redirectAttributes, "删除产品成功");
		return "redirect:"+Global.ADMIN_PATH+"/modules/product/item/productItem/?repage";
	}

}
