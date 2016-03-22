package com.movie.member.web;

import java.util.HashMap;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class MemberServiceImpl implements MemberService{
	HashMap<String, MemberBean> map;
	MemberDAOImpl dao = new MemberDAOImpl();
	
	public MemberServiceImpl() {
		map = new HashMap<String, MemberBean>();
	}
	
	@Override
	public void join(MemberBean member) {
		// 회원가입
		map.put(member.getId(), member);
	}

	@Override
	public MemberBean login(String id, String password) {
		// 로그인
		/* 아이디가 존재하지않아서 실패한 경우와 
		 * 비번이 틀려서 실패한 경우에 따라서 메세지를 전달해야 함
		 * */
		MemberBean member = new MemberBean();
		member = dao.selectMember(id);
		
		if (member.getPassword().equals(password)) {
			return member;
		} else {
			return null;
		}
		
	}
	
	@Override
	public MemberBean detail(String id) {
		return dao.selectMember(id);
	}
	
	@Override
	public String update(MemberBean member) {
		// 수정
		String result = "수정 실패";
		MemberBean searchMember = map.get(member.getId());
		
		if ( searchMember != null ) {
			searchMember.setPassword(member.getPassword());
			searchMember.setName(member.getName());
			searchMember.setBirth(member.getBirth());
			searchMember.setAddr(member.getAddr());
			
			result = "수정 성공";
		}
		
		return result;
	}

	@Override
	public String remove(String id) {
		// 삭제
		
		return (map.remove(id).getId().equals(id)) ? "삭제완료" : "삭제실패" ;
	}

	@Override
	public boolean isMember(String id) {
		boolean member = false;
		member = dao.isMember(id);
		
		if (member == true) {
			return member;
		} else {
			return false;
		}
		
	}

}
