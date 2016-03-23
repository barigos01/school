package com.movie.web.admin;

import java.util.List;

import com.movie.web.grade.GradeBean;
import com.movie.web.grade.GradeMemberBean;

public class AdminServiceImpl implements AdminService {
	AdminDAO dao = AdminDAOImpl.getInstance();
	private static AdminService instance = new AdminServiceImpl();
	
	public static AdminService getInstance() {
		return instance;
	}
	
	@Override
	public List<GradeMemberBean> getMemberList() {
		return dao.getMemberList();
	}

	@Override
	public int addScore(GradeBean bean) {
		return 0;
	}


}
