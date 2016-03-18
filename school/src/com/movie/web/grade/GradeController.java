package com.movie.web.grade;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;

public class GradeController {
	public static void main(String[] arservice) {
		Scanner scanner = new Scanner(System.in);
		GradeService service = new GradeServiceImpl();
		ArrayList<GradeMemberBean> gmList = new ArrayList<GradeMemberBean>();
		GradeMemberBean gmbean = new GradeMemberBean();
		
		while (true) {
			System.out.println("[메뉴] 1.등록 2.수정 3.삭제 4.조회(전체) 5.조회(이름) 6.조회(학번) 7.회원수 0.종료");
			
			switch (scanner.nextInt()) {
			case 1: 
				System.out.println("학번, 이름, 자바, SQL, JSP, 스프링 입력");
				//service.input(new GradeBean(scanner.nextInt(), scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
				break;
			case 2:	
				/*System.out.println("수정하려는 성적표의 학번, 자바, SQL, JSP, 스프링 입력하시오.");
				int hak = scanner.nextInt();
				String name = service.getGradeByHak(hak).getId();
				System.out.println(service.update(new GradeBean(hak, name, scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt()))); 
				 */
				break;
			case 3:	
				System.out.println("삭제하려는 학번 입력");
				gmbean = service.delete(scanner.nextInt()); 
				System.out.println(gmbean.toString());
				break;
			case 4:
				gmList = service.getList();
				System.out.println(gmList.toString());
				break;
			case 5:
				System.out.println("조회하려는 이름 입력");
				gmList = service.getGradeByName(scanner.next());
				System.out.println(gmList.toString());
				break;
			case 6:	
				System.out.println("조회하려는 학번 입력");
				gmbean = service.getGradeByHak(scanner.nextInt());
				System.out.println(gmbean.toString());
				
				//GradeBean grade = (GradeBean) map.get("grade");
				/*System.out.println(map.get("member"));
				System.out.println(map.get("grade"));*/
				break;
			case 7:	
				System.out.println(service.getCount() + "명");
				break;
			case 0:
				System.out.println("종료");
				return;

			default: 
				System.out.println("잘못입력");
				return;
			}
			
		}
		
	}
}
