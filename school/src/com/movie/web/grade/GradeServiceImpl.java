package com.movie.web.grade;

import java.util.ArrayList;

public class GradeServiceImpl implements GradeService {
	// 멤버 필드
	ArrayList<GradeBean> gradeList;

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
	public ArrayList<GradeBean> getList() {
		// R : 성적표 리스트 출력
		return gradeList;		
	}

	@Override
	public GradeBean getGradeByHak(int hak) {
		// R : 성적표 조회(학번)
		GradeBean tempGrade = new GradeBean();
		
		for (int i = 0; i < gradeList.size(); i++) {
			int searchHak = gradeList.get(i).getHak();	// 벡터
			
			if (searchHak == hak) {
				tempGrade = gradeList.get(i);
				break;
			}
		}
		return tempGrade;
	}

	@Override
	public ArrayList<GradeBean> getGradeByName(String name) {
		// R : 성적표 조회(이름)
		ArrayList<GradeBean> tempList = new ArrayList<GradeBean>();
		
		for (int i = 0; i < gradeList.size(); i++) {
			if (name.equals(gradeList.get(i).getId())) {
				tempList.add(gradeList.get(i));
			}
		}
		
		return tempList;
	}

	@Override
	public int getCount() {
		// R : 카운트 조회
		return gradeList.size();
	}

	@Override
	public void getCountByName() {
		// R : 이름 조회시 카운트 조회

	}

	@Override
	public String update(GradeBean grade) {
		// U 성적표 수정	      
		String temp = "수정 실패";
		GradeBean searchedGrade = getGradeByHak(grade.getHak());

		if( gradeList.contains(searchedGrade) ){
		
			searchedGrade.setJava	(grade.getJava());
			searchedGrade.setSql	(grade.getSql());
			searchedGrade.setJsp	(grade.getJsp());
			searchedGrade.setSpring (grade.getSpring());

			temp = "수정 성공";
		}
		
		return temp;
	}

	@Override
	public String delete(int hak) {
		// D : 성적표 삭제
		return (gradeList.remove(getGradeByHak(hak))) ? "삭제 성공" : "삭제 실패";
	}

}
