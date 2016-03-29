package com.movie.web.admin;

import java.util.List;

import com.movie.web.grade.GradeBean;
import com.movie.web.grade.GradeMemberBean;
import com.movie.web.member.MemberBean;

public interface AdminService {
	public List<MemberBean> getMemberList();
	public List<GradeMemberBean> getGradeList();
	public int addScore(GradeBean bean);
	public AdminBean selectAdmin(AdminBean admin);
}
