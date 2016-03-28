package com.movie.web.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.movie.web.global.Constants;
import com.movie.web.global.DatabaseFactory;
import com.movie.web.global.Vendor;
import com.movie.web.grade.GradeBean;
import com.movie.web.grade.GradeMemberBean;
import com.movie.web.member.MemberBean;

public class AdminDAOImpl implements AdminDAO {
	private Connection conn;			// 오라클 연결 객체
	private Statement stmt;				// 쿼리 전송 객체
	private PreparedStatement pstmt;	// 쿼리 전송 객체2
	private ResultSet rs;				// 리턴값 회수 객체
	private static AdminDAO instance = new AdminDAOImpl();
	
	public static AdminDAO getInstance() {
		return instance;
	}

	public AdminDAOImpl() {
		conn = DatabaseFactory.getDatabase(Vendor.ORACLE, Constants.ID, Constants.PASSWORD).getConnection();
	}
	
	@Override
	public List<MemberBean> getMemberList() {
		List<MemberBean> mList = new ArrayList<MemberBean>();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Member");
			
			while(rs.next()){
				MemberBean bean = new MemberBean();
				
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setAddr(rs.getString("addr"));
				bean.setBirth(rs.getInt("birth"));
				
				mList.add(bean);
			}
		} catch (Exception e) {
			System.out.println("getMemberList()에서 에러 발생");
			e.printStackTrace();
		}
		
		System.out.println("멤버리스트" + mList);
		return mList;	
	}
	
	@Override
	public List<GradeMemberBean> getGradeList() {
		List<GradeMemberBean> gmList = new ArrayList<GradeMemberBean>();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM GradeMember");
			
			while(rs.next()){
				GradeMemberBean bean = new GradeMemberBean();
				
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setScore_seq(rs.getInt("score_seq"));
				bean.setJava(rs.getInt("java"));
				bean.setJsp(rs.getInt("jsp"));
				bean.setSpring(rs.getInt("spring"));
				bean.setSql(rs.getInt("sql"));
				
				gmList.add(bean);
			}
		} catch (Exception e) {
			System.out.println("getGradeList()에서 에러 발생");
			e.printStackTrace();
		}
		
		return gmList;	
	}

	@Override
	public int addScore(GradeBean bean) {
		return 0;
	}

	@Override
	public AdminBean selectAdmin(String id, String password) {
		AdminBean bean = new AdminBean();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Admin WHERE id='" + id + "' and password='" + password + "'");
			
			while (rs.next()) {
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setAddr(rs.getString("addr"));
				bean.setBirth(rs.getInt("birth"));
				bean.setRole(rs.getString("role"));
			}
		} catch (Exception e) {
			System.out.println("selectAdmin()에서 에러 발생");
			e.printStackTrace();
		}
		
		return bean;
	}

}
