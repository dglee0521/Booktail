package org.booktail.service;

import java.util.ArrayList;

import org.booktail.domain.CartDTO;
import org.booktail.domain.CartListDTO;
import org.booktail.domain.Criteria;
import org.booktail.domain.ItemDTO;
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
	public void deleteCart(CartDTO cdto) throws Exception{
		imapper.deleteCart(cdto);
	}
}
