package org.booktail.service;

import java.util.ArrayList;

import org.booktail.domain.CartDTO;
import org.booktail.domain.CartListDTO;
import org.booktail.domain.Criteria;
import org.booktail.domain.ItemDTO;
import org.booktail.domain.OrderDTO;
import org.booktail.domain.OrderDetailDTO;

public interface ItemService {
	public void regist(ItemDTO idto);
	
	public ItemDTO detail(ItemDTO idto);
	
	public ArrayList<ItemDTO> list(Criteria cri);
	
	public int getTotalCount(Criteria cri);
	
	public void addCart(CartDTO cdto) throws Exception;
	
	public ArrayList<CartListDTO> cartList(String userId) throws Exception;
	
	public void changeStock(CartDTO cdto) throws Exception;
	
	public void deleteCart(CartDTO cdto) throws Exception;
	
	//주문 정보
	public void orderInfo(OrderDTO order) throws Exception;
	
	//주문 상세정보
	public void orderInfo_Details(OrderDetailDTO orderDetail) throws Exception;
	
	//카트 비우기
	public void cartAllDelete(String userId) throws Exception;
	//주문 목록
	public ArrayList<OrderDTO> orderList(OrderDTO order) throws Exception;
}
