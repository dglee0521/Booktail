package org.booktail.controller;

import javax.servlet.http.HttpSession;

import org.booktail.domain.CartDTO;
import org.booktail.domain.Criteria;
import org.booktail.domain.ItemDTO;
import org.booktail.domain.MemberDTO;
import org.booktail.domain.PageDTO;
import org.booktail.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("shop")
@Controller
public class ShopController {
	@Autowired
	private ItemService iservice;
	
	@GetMapping("/")
	public String shopList(ItemDTO idto,Criteria cri, Model model) {
		
		model.addAttribute("list", iservice.list(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, iservice.getTotalCount(cri)));
		return "shop/shop";
	}
	
	@GetMapping("item")
	public String shopItem() {
		return "shop/item";
	}
	
	@GetMapping("detail")
	public String detail(Model model, ItemDTO idto) {
		model.addAttribute("detail", iservice.detail(idto));
		return "shop/itemDetail";
	}
	
	@GetMapping("itemReg")
	public String shopItemReg() {
		return "shop/shopItemReg";
	}
	
	@PostMapping("itemReg")
	public String postReg(ItemDTO idto) {
		iservice.regist(idto);
		return "redirect:/shop/";
	}
	
	@GetMapping("basket")
	public String basket() {
		
		return "shop/basket";
	}
	
	@ResponseBody
	@RequestMapping(value = "/addCart", method = RequestMethod.POST)
	public int addCart(CartDTO cart, HttpSession session) throws Exception {
	 
	 int result = 0;
	 MemberDTO member = (MemberDTO)session.getAttribute("login");
	 System.out.println("id : " +member.getId());
	 if(member != null) {
	  cart.setUserId(member.getId());
	  iservice.addCart(cart);
	  result = 1;
	 }

	 return result;
	}
}
