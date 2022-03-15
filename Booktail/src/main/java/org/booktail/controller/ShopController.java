package org.booktail.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.booktail.domain.CartDTO;
import org.booktail.domain.CartListDTO;
import org.booktail.domain.Criteria;
import org.booktail.domain.ItemDTO;
import org.booktail.domain.MemberDTO;
import org.booktail.domain.OrderDTO;
import org.booktail.domain.OrderDetailDTO;
import org.booktail.domain.PageDTO;
import org.booktail.domain.ReviewDTO;
import org.booktail.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("shop")
@Controller
public class ShopController {
	
	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
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
	public String detail(Model model, ItemDTO idto, ReviewDTO rdto) {
		model.addAttribute("detail", iservice.detail(idto));
		model.addAttribute("reviews", iservice.reviews(rdto));
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
	
	@GetMapping(value = "/basket")
	public String basket(HttpSession session, Model model) throws Exception {
		 
		 MemberDTO member = (MemberDTO)session.getAttribute("login");
		 String userId = member.getId();
		 
		 ArrayList<CartListDTO> cartList = iservice.cartList(userId);
		 
		 model.addAttribute("cartList", cartList);
		 
		 return "shop/basket";
	}
	
	@ResponseBody
	@PostMapping(value = "/addCart")
	public int addCart(CartDTO cart, HttpSession session) throws Exception {
	 
	 int result = 0;
	 MemberDTO member = (MemberDTO)session.getAttribute("login");
	 System.out.println("id : " +member.getId());
	 if(member != null) {
		 cart.setUserId(member.getId());
		 if(iservice.checkCart(cart)==1) {
			 iservice.updateStock(cart);
			 result = 1;
		 } else {
			 iservice.addCart(cart);
			 result = 1;
		 }
	 }

	 return result;
	 
	}
	@ResponseBody
	@PostMapping(value="/changeStock")
	public int changeStock(HttpSession session, CartDTO cart) throws Exception {
		MemberDTO member = (MemberDTO)session.getAttribute("login");
		 String userId = member.getId();
		 
		 int result = 0;
		 int cartNum = 0;
		 
		 if(member != null) {
			  cart.setUserId(userId);
			  
			  result = 1;
			  iservice.changeStock(cart);
			 }  
			 return result;  
	}
	// 카트 삭제
	@ResponseBody
	@PostMapping(value = "/deleteCart")
	public int deleteCart(HttpSession session, @RequestParam(value = "chbox[]") ArrayList<String> chArr, CartDTO cart) throws Exception {

	 MemberDTO member = (MemberDTO)session.getAttribute("login");
	 String userId = member.getId();
	 
	 int result = 0;
	 int cartNum = 0;
	 
	 
	 if(member != null) {
	  cart.setUserId(userId);
	  
	  for(String i : chArr) {   
	   cartNum = Integer.parseInt(i);
	   cart.setCartNum(cartNum);
	   iservice.deleteCart(cart);
	  }   
	  result = 1;
	  
	 }  
	 System.out.println(result);
	 return result;  
	}
	
	// 주문하기
	@PostMapping(value = "/cartList")
	public String order(HttpSession session, OrderDTO order, OrderDetailDTO orderDetail) throws Exception {
		 logger.info("order");
		 
		 MemberDTO member = (MemberDTO)session.getAttribute("login");  
		 String userId = member.getId();
		 
		 Calendar cal = Calendar.getInstance();
		 int year = cal.get(Calendar.YEAR);
		 String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		 String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));
		 String subNum = "";
		 
		 for(int i = 1; i <= 6; i ++) {
		  subNum += (int)(Math.random() * 10);
		 }
		 
		 String orderId = ymd + "_" + subNum;
		 
		 order.setOrderId(orderId);
		 order.setUserId(userId);
		  
		 iservice.orderInfo(order);
		 
		 orderDetail.setOrderId(orderId);   
		 iservice.orderInfo_Details(orderDetail);
		 System.out.println(userId);
		 iservice.cartAllDelete(userId);
		 
		 return "redirect:/shop/orderList";
	}
	
	// 주문 목록
	@GetMapping(value = "/orderList")
	public void getOrderList(HttpSession session, OrderDTO order, Model model) throws Exception {
	 logger.info("get order list");
	 
	 MemberDTO member = (MemberDTO)session.getAttribute("login");
	 String userId = member.getId();
	 
	 order.setUserId(userId);
	 System.out.println(order.getUserId());
	 ArrayList<OrderDTO> orderList = iservice.orderList(order);
	 
	 model.addAttribute("orderList", orderList);
	}
	
	// 상품 조회 - 소감(댓글) 작성
	@PostMapping(value = "registReview")
	public String registReply(ReviewDTO rdto, HttpSession session) throws Exception {
	 logger.info("regist review");
	 
	 MemberDTO member = (MemberDTO)session.getAttribute("login");
	 rdto.setUserId(member.getId());
	 
	 iservice.registReview(rdto);
	 
	 return "redirect:/shop/detail?gdsNum=" + rdto.getGdsNum();
	}
	
}
