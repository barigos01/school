package com.movie.web.grade;

import java.util.ArrayList;
import java.util.Map;

/**
 * CRUD
 * C : create	생성
 * R : read		조회
 * U : update	수정
 * D : delete	삭제
 * */
public interface GradeService {
	// C : 성적표 출력
	public void input(GradeBean grade);	// 추상 메소드 (기능을 추상화한다. 속성은 추상화하지않는다.)
	
	// R : 성적표 리스트 출력
	public ArrayList<GradeMemberBean> getList();
	
	// R : 성적표 조회(학번)
	public GradeMemberBean getGradeByHak(int hak);
	
	// R : 성적표 조회(이름)
	public ArrayList<GradeMemberBean> getGradeByName(String name);
	
	// R : 카운트 조회
	public int getCount();
	
	// U : 성적표 수정
	public String update(GradeBean grade);
	
	// D : 성적표 삭제
	public GradeMemberBean delete(int hak); 
	
}
