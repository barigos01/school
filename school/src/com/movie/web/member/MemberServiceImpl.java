package com.movie.web.member;

import java.util.HashMap;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class MemberServiceImpl implements MemberService{
	HashMap<String, MemberBean> map;
	MemberDAO dao = MemberDAOImpl.getInstance();
	private static MemberService instance = new MemberServiceImpl();
	
	public static MemberService getInstance() {
		return instance;
	}
	
	public MemberServiceImpl() {
		map = new HashMap<String, MemberBean>();
	}
	
	@Override
	public int join(MemberBean member) {
		// 회원가입
		return dao.insert(member);
	}

	@Override
	public MemberBean login(String id, String password) {
		// 로그인
		/* 아이디가 존재하지않아서 실패한 경우와 
		 * 비번이 틀려서 실패한 경우에 따라서 메세지를 전달해야 함
		 * */
		MemberBean member = new MemberBean();
		member = dao.selectById(id, password);
		
		if (member != null) {
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
	public int update(MemberBean member) {
		// 수정
		return dao.update(member);
	}

	@Override
	public int remove(String id) {
		// 삭제
		return dao.delete(id);
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
