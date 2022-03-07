package org.booktail.service;

import java.util.ArrayList;

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
}
