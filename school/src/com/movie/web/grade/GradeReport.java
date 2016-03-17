package com.movie.web.grade;

import java.util.Scanner;

/**
 * @file : GradeReport.java
 * @author eunji
 * @date 2016. 3. 11.
 * @story 성적표(점수에 따라 A ~ F까지 학점부여)
 * [결과]
 * ******************************
 * 이름		과목		점수		학점
 * ------------------------------
 * 홍길동		영어		89점		 B
 * ******************************
 * 90점 이상 A
 * 80점 이상 B
 * 70점 이상 C
 * 60점 이상 D
 * 50점 이상 E
 * 50점 미만 F
 * 만약 입력한 점수가 100점 초과 또는 0점 미만이면
 * '잘 못 입력했습니다' 메세지 출력
 */
public class GradeReport {
	public static void main(String[] args) {
		System.out.println("성적표(점수에 따라 A ~ F까지 학점부여)");
		System.out.println("이름, 과목, 점수를 입력");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next(), subject = scanner.next(), result = "";
		int score = scanner.nextInt();
		
		if (score>=90) {
			result = "A";
		} else if(score>=80) {
			result = "B";
		} else if(score>=70) {
			result = "C";
		} else if(score>=60) {
			result = "D";
		} else if(score>=50) {
			result = "E";
		} else if(score<50) {
			result = "F";
		} else {
			result = "잘 못 입력하셨습니다.";
			return;
		}
		
		System.out.println("******************************");
		System.out.println("이름\t 과목\t 점수\t 학점");
		System.out.println("------------------------------");
		System.out.println(name+"\t"+subject+"\t"+score+"\t"+result);
		System.out.println("******************************");
	}
}
