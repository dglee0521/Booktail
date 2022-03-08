package org.booktail.service;

import java.util.ArrayList;

import org.booktail.domain.MemberDTO;
import org.booktail.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberMapper mmapper;
	
	public void insert(MemberDTO mdto) {
		mmapper.insert(mdto);
	}
	
	public MemberDTO login(MemberDTO mdto){

		return mmapper.login(mdto);
	}
	
	public ArrayList<String> getId() {
		return mmapper.getId();
	}
	
	public int idpwChk(MemberDTO mdto) {
		return mmapper.idpwChk(mdto);
	}
	
	public int idChk(MemberDTO mdto) {
		return mmapper.idChk(mdto);
	}
	
	
}
