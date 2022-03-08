package org.booktail.mapper;

import java.util.ArrayList;

import org.booktail.domain.CartDTO;
import org.booktail.domain.Criteria;
import org.booktail.domain.ItemDTO;

public interface ItemMapper {
	public void regist(ItemDTO idto);
	
	public ItemDTO detail(ItemDTO idto);
	
	public ArrayList<ItemDTO> list(Criteria cri);
	
	public int getTotalCount(Criteria cri);
	
	public void addCart(CartDTO cdto);
}
