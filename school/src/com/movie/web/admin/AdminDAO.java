package com.movie.web.admin;

import java.util.List;

import com.movie.web.grade.GradeBean;
import com.movie.web.grade.GradeMemberBean;
import com.movie.web.member.MemberBean;

public interface AdminDAO {
	public List<MemberBean> getMemberList();
	public List<GradeMemberBean> getGradeList();
	public int addScore(GradeBean bean);
	public AdminBean selectAdmin(String id, String password);
}
