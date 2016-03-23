package com.movie.web.grade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.movie.web.global.Constants;
import com.movie.web.global.DatabaseFactory;
import com.movie.web.global.Vendor;
import com.movie.web.member.MemberBean;

public class GradeDAOImpl implements GradeDAO {
	private Connection conn;			// 오라클 연결 객체
	private Statement stmt;				// 쿼리 전송 객체
	private PreparedStatement pstmt;	// 쿼리 전송 객체2
	private ResultSet rs;				// 리턴값 회수 객체
	private static GradeDAO instance = new GradeDAOImpl();
	
	public static GradeDAO getInstance() {
		return instance;
	}

	public GradeDAOImpl() {
		conn = DatabaseFactory.getDatabase(Vendor.ORACLE, Constants.ID, Constants.PASSWORD).getConnection();
	}
	
	@Override
	public void insert(GradeBean grade) {
		
		
	}

	@Override
	public ArrayList<GradeMemberBean> selectAll() {
		ArrayList<GradeMemberBean> gmList = new ArrayList<GradeMemberBean>();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM GradeMember");
			
			while(rs.next()){
				GradeMemberBean bean = new GradeMemberBean();
				
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setAddr(rs.getString("addr"));
				bean.setBirth(rs.getInt("birth"));
				bean.setScore_seq(rs.getInt("score_seq"));
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
	public GradeMemberBean selectGradeByHak(int score_seq) {
		MemberBean member = new MemberBean();
		GradeBean grade = new GradeBean();
		GradeMemberBean bean = new GradeMemberBean();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM GradeMember WHERE score_seq = " + "'" + score_seq + "'");
			
			while(rs.next()){
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setAddr(rs.getString("addr"));
				bean.setBirth(rs.getInt("birth"));
				bean.setScore_seq(rs.getInt("score_seq"));
				bean.setJava(rs.getInt("java"));
				bean.setJsp(rs.getInt("jsp"));
				bean.setSpring(rs.getInt("spring"));
				bean.setSql(rs.getInt("sql"));
			}
		} catch (Exception e) {
			System.out.println("selectGradeByHak()에서 에러 발생");
			e.printStackTrace();
		}
		
		return bean;	
	}

	@Override
	public ArrayList<GradeMemberBean> selectGradeByName(String name) {
		ArrayList<GradeMemberBean> gmList = new ArrayList<GradeMemberBean>();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM GradeMember WHERE name = " + "'" + name + "'");
			
			while(rs.next()){
				GradeMemberBean bean = new GradeMemberBean();
				
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setAddr(rs.getString("addr"));
				bean.setBirth(rs.getInt("birth"));
				bean.setScore_seq(rs.getInt("score_seq"));
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
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(*) AS count FROM Member");
			
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
	public GradeMemberBean delete(int score_seq) {
		GradeMemberBean bean = new GradeMemberBean();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("DELETE FROM GradeMember WHERE score_seq = " + score_seq);
			
		} catch (Exception e) {
			System.out.println("delete()에서 에러 발생");
			e.printStackTrace();
		}
		
		return bean;
	}

	@Override
	public GradeMemberBean selectGradeById(String id) {
		MemberBean member = new MemberBean();
		GradeBean grade = new GradeBean();
	//	Map<String, Object> map = new HashMap<String, Object>();
		GradeMemberBean bean = new GradeMemberBean();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM GradeMember WHERE id = " + "'" + id + "'");
			
			while(rs.next()){
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setAddr(rs.getString("addr"));
				bean.setBirth(rs.getInt("birth"));
				bean.setScore_seq(rs.getInt("score_seq"));
				bean.setJava(rs.getInt("java"));
				bean.setJsp(rs.getInt("jsp"));
				bean.setSpring(rs.getInt("spring"));
				bean.setSql(rs.getInt("sql"));
			}
		} catch (Exception e) {
			System.out.println("selectGradeById()에서 에러 발생");
			e.printStackTrace();
		}
		
		return bean;	
	}

}
