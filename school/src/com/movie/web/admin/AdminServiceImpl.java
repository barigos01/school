package com.movie.web.admin;

import java.util.List;

import com.movie.web.grade.GradeBean;
import com.movie.web.grade.GradeMemberBean;
import com.movie.web.member.MemberBean;

public class AdminServiceImpl implements AdminService {
	AdminDAO dao = AdminDAOImpl.getInstance();
	private static AdminService instance = new AdminServiceImpl();
	
	public static AdminService getInstance() {
		return instance;
	}
	
	@Override
	public List<MemberBean> getMemberList() {
		return dao.getMemberList();
	}
	
	@Override
	public List<GradeMemberBean> getGradeList() {
		return dao.getGradeList();
	}


	@Override
	public int addScore(GradeBean bean) {
		return 0;
	}

	@Override
	public AdminBean selectAdmin(String id, String password) {
		return dao.selectAdmin(id, password);
	}



}
