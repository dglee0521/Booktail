package org.booktail.service;

import java.util.ArrayList;

import org.booktail.domain.CartDTO;
import org.booktail.domain.CartListDTO;
import org.booktail.domain.Criteria;
import org.booktail.domain.ItemDTO;
import org.booktail.domain.OrderDTO;
import org.booktail.domain.OrderDetailDTO;
import org.booktail.domain.ReviewDTO;
import org.booktail.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService{
	@Autowired
	private ItemMapper imapper;
	
	public void regist(ItemDTO idto) {
		imapper.regist(idto);
	}
	
	public ItemDTO detail(ItemDTO idto) {
		return imapper.detail(idto);
	}
	
	public ArrayList<ItemDTO> list(Criteria cri){
		return imapper.list(cri);
	}
	
	public int getTotalCount(Criteria cri) {
		return imapper.getTotalCount(cri);
	}
	
	public void addCart(CartDTO cdto) throws Exception{
		imapper.addCart(cdto);
	}
	
	public ArrayList<CartListDTO> cartList(String userId) throws Exception{
		return imapper.cartList(userId);
	}
	
	public void changeStock(CartDTO cdto) throws Exception{
		imapper.changeStock(cdto);
	}
	
	public int checkCart(CartDTO cdto) throws Exception{
		return imapper.checkCart(cdto);
	}
	
	public void updateStock(CartDTO cdto) throws Exception{
		imapper.updateStock(cdto);
	}
	
	public void deleteCart(CartDTO cdto) throws Exception{
		imapper.deleteCart(cdto);
	}
	
	//주문 정보
	public void orderInfo(OrderDTO order) throws Exception{
		imapper.orderInfo(order);
	}
	
	//주문 상세정보
	public void orderInfo_Details(OrderDetailDTO orderDetail) throws Exception{
		imapper.orderInfo_Details(orderDetail);
	}
	
	//주문 목록
	public ArrayList<OrderDTO> orderList(OrderDTO order) throws Exception{
		return imapper.orderList(order);
	}
	
	//카트 비우기
	public void cartAllDelete(String userId) throws Exception{
		imapper.cartAllDelete(userId);
	}
	
	//상품 리뷰
	public void registReview(ReviewDTO rdto) throws Exception{
		imapper.registReview(rdto);
	}
	
	//상품 리뷰 조회
	public ArrayList<ReviewDTO> reviews(ReviewDTO rdto){
		return imapper.reviews(rdto);
	}
}
