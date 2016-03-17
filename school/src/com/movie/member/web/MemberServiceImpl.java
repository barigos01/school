package com.movie.member.web;

import java.util.HashMap;

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
	public String login(String id, String password) {
		// 로그인
		/* 아이디가 존재하지않아서 실패한 경우와 
		 * 비번이 틀려서 실패한 경우에 따라서 메세지를 전달해야 함
		 * */
		String result = "";
		
		if (map.containsKey(id)) {
			if (map.get(id).getPassword().equals(password)) {
				result = "로그인 성공";
			} else{
				result = "비밀번호 틀림";
			}
		} else{
			result = "아이디가 없음";
		}
		
/*		if (map.get(id).getId().equals(id) && map.get(id).getPassword().equals(password)) {
			result = "로그인 성공";
		} else if (! map.get(id).getId().equals(id)) {
			result = "아이디가 존재하지 않습니다";
		} else if (! map.get(id).getPassword().equals(password)) {
			result = "비밀번호가 틀렸습니다";
		}*/
		
		return result;
		
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

}
