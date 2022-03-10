package org.booktail.service;

import java.util.ArrayList;

import org.booktail.domain.CartDTO;
import org.booktail.domain.CartListDTO;
import org.booktail.domain.Criteria;
import org.booktail.domain.ItemDTO;

public interface ItemService {
	public void regist(ItemDTO idto);
	
	public ItemDTO detail(ItemDTO idto);
	
	public ArrayList<ItemDTO> list(Criteria cri);
	
	public int getTotalCount(Criteria cri);
	
	public void addCart(CartDTO cdto) throws Exception;
	
	public ArrayList<CartListDTO> cartList(String userId) throws Exception;
	
	public void changeStock(CartDTO cdto) throws Exception;
	
	public void deleteCart(CartDTO cdto) throws Exception;
}
