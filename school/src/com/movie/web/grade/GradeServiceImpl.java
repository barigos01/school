package com.movie.web.grade;

import java.util.ArrayList;
import java.util.Map;

public class GradeServiceImpl implements GradeService {
	// 멤버 필드
	ArrayList<GradeBean> gradeList;
	private static GradeService instance = new GradeServiceImpl();
	GradeDAO dao = GradeDAOImpl.getInstance();
	
	public static GradeService getInstance() {
		return instance;
	}

	public GradeServiceImpl() {
		gradeList = new ArrayList<GradeBean>(); // 초기화(초기화는 메서드에서!)
	}

	// 멤버 메소드 에어리어
	@Override
	public void input(GradeBean grade) {
		// C : 성적표 출력
		gradeList.add(new GradeBean(2, "김구", 100, 100, 100, 100));
		gradeList.add(new GradeBean(3, "강감찬", 90, 90, 90, 90));
		gradeList.add(new GradeBean(4, "유관순", 80, 80, 80, 80));
		gradeList.add(new GradeBean(5, "김구", 70, 70, 70, 70));
		
		gradeList.add(grade);
	}

	@Override
	public ArrayList<GradeMemberBean> getList() {
		// R : 성적표 리스트 출력
		return dao.selectAll();		
	}

	@Override
	public GradeMemberBean getGradeByHak(int hak) {
		// R : 성적표 조회(학번)
		return dao.selectGradeByHak(hak);
	}

	@Override
	public ArrayList<GradeMemberBean> getGradeByName(String name) {
		// R : 성적표 조회(이름)
		return dao.selectGradeByName(name);
	}

	@Override
	public int getCount() {
		// R : 카운트 조회
		return dao.count();
	}

	@Override
	public String update(GradeBean grade) {
		// U 성적표 수정	      
		String temp = "수정 실패";
		/*GradeBean searchedGrade = getGradeByHak(grade.getHak());

		if( gradeList.contains(searchedGrade) ){
		
			searchedGrade.setJava	(grade.getJava());
			searchedGrade.setSql	(grade.getSql());
			searchedGrade.setJsp	(grade.getJsp());
			searchedGrade.setSpring (grade.getSpring());

			temp = "수정 성공";
		}*/
		
		return temp;
	}

	@Override
	public GradeMemberBean delete(int hak) {
		// D : 성적표 삭제
		return dao.delete(hak);
	}

	@Override
	public GradeMemberBean selectGradeById(String id) {
		return dao.selectGradeById(id);
	}

	@Override
	public int insertGrade(GradeBean grade) {
		// TODO Auto-generated method stub
		return dao.insertGrade(grade);
	}

}
