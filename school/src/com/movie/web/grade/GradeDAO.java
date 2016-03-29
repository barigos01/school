package com.movie.web.grade;

import java.util.ArrayList;
import java.util.Map;

public interface GradeDAO {
	// C : 성적표 출력
	public void insert(GradeBean grade);	// 추상 메소드 (기능을 추상화한다. 속성은 추상화하지않는다.)
	
	// R : 성적표 리스트 출력
	public ArrayList<GradeMemberBean> selectAll();
	
	// R : 성적표 조회(학번)
	public GradeMemberBean selectGradeByHak(int hak);
	
	// R : 성적표 조회(이름)
	public ArrayList<GradeMemberBean> selectGradeByName(String name);
	
	// R : 카운트 조회
	public int count();
	
	// U : 성적표 수정
	public String update(GradeBean grade);
	
	// D : 성적표 삭제
	public GradeMemberBean delete(int hak); 
	
	public GradeMemberBean selectGradeById(String id);
	
	public int insertGrade(GradeBean grade);
}
