package org.booktail.service;

import java.util.ArrayList;

import org.booktail.domain.MemberDTO;

public interface MemberService {
	public void insert(MemberDTO mdto);
	
	public MemberDTO login(MemberDTO mdto);
	
	public ArrayList<String> getId();
	
	public int idpwChk(MemberDTO mdto);
	
	public int idChk(MemberDTO mdto);
	
}
