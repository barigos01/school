package com.movie.web.grade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.movie.member.web.MemberBean;
import com.movie.web.global.Constants;

public class GradeDAOImpl implements GradeDAO {
	private Connection conn;			// 오라클 연결 객체
	private Statement stmt;				// 쿼리 전송 객체
	private PreparedStatement pstmt;	// 쿼리 전송 객체2
	private ResultSet rs;				// 리턴값 회수 객체
	
	@Override
	public void insert(GradeBean grade) {
		
		
	}

	@Override
	public ArrayList<GradeMemberBean> selectAll() {
		ArrayList<GradeMemberBean> gmList = new ArrayList<GradeMemberBean>();
		
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM GradeMember");
			
			while(rs.next()){
				GradeMemberBean bean = new GradeMemberBean();
				
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setAddr(rs.getString("addr"));
				bean.setBirth(rs.getInt("birth"));
				bean.setHak(rs.getInt("hak"));
				bean.setJava(rs.getInt("java"));
				bean.setJsp(rs.getInt("jsp"));
				bean.setSpring(rs.getInt("spring"));
				bean.setSql(rs.getInt("sql"));
				
				gmList.add(bean);
			}
		} catch (Exception e) {
			System.out.println("selectAll()에서 에러 발생");
			e.printStackTrace();
		}
		
		return gmList;	
	}

	@Override
	public GradeMemberBean selectGradeByHak(int hak) {
		MemberBean member = new MemberBean();
		GradeBean grade = new GradeBean();
	//	Map<String, Object> map = new HashMap<String, Object>();
		GradeMemberBean bean = new GradeMemberBean();
		
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM GradeMember WHERE hak = " + "'" + hak + "'");
			
			while(rs.next()){
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setAddr(rs.getString("addr"));
				bean.setBirth(rs.getInt("birth"));
				bean.setHak(rs.getInt("hak"));
				bean.setJava(rs.getInt("java"));
				bean.setJsp(rs.getInt("jsp"));
				bean.setSpring(rs.getInt("spring"));
				bean.setSql(rs.getInt("sql"));
				
				/*member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setPassword(rs.getString("password"));
				member.setAddr(rs.getString("addr"));
				member.setBirth(rs.getInt("birth"));
				grade.setId(rs.getString("id"));
				grade.setHak(rs.getInt("hak"));
				grade.setJava(rs.getInt("java"));
				grade.setJsp(rs.getInt("jsp"));
				grade.setSpring(rs.getInt("spring"));
				grade.setSql(rs.getInt("sql"));*/
			}
		} catch (Exception e) {
			System.out.println("selectGradeByHak()에서 에러 발생");
			e.printStackTrace();
		}
//		map.put("member", member);
//		map.put("grade", grade);
		
		return bean;	
	}

	@Override
	public ArrayList<GradeMemberBean> selectGradeByName(String name) {
		ArrayList<GradeMemberBean> gmList = new ArrayList<GradeMemberBean>();
		
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM GradeMember WHERE name = " + "'" + name + "'");
			
			while(rs.next()){
				GradeMemberBean bean = new GradeMemberBean();
				
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setAddr(rs.getString("addr"));
				bean.setBirth(rs.getInt("birth"));
				bean.setHak(rs.getInt("hak"));
				bean.setJava(rs.getInt("java"));
				bean.setJsp(rs.getInt("jsp"));
				bean.setSpring(rs.getInt("spring"));
				bean.setSql(rs.getInt("sql"));
				
				gmList.add(bean);
			}
		} catch (Exception e) {
			System.out.println("selectGradeByName()에서 에러 발생");
			e.printStackTrace();
		}
		
		return gmList;	
	}

	@Override
	public int count() {
		int count = 0;
		
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(*) AS count FROM Member");
			
/*			stmt.executeQuery("SELECT COUNT(*) AS count FROM Member").last();
			count = rs.getRow();*/
			
			while (rs.next()) {
				count = rs.getInt("count");
			}
			
		} catch (Exception e) {
			System.out.println("count()에서 에러 발생");
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public String update(GradeBean grade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GradeMemberBean delete(int hak) {
		GradeMemberBean bean = new GradeMemberBean();
		
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("DELETE FROM GradeMember WHERE hak = " + hak);
			
		} catch (Exception e) {
			System.out.println("delete()에서 에러 발생");
			e.printStackTrace();
		}
		
		return bean;
	}

}
