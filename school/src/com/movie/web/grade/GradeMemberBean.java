package com.movie.web.grade;

public class GradeMemberBean {
	private String id, password, name, addr;
	private int birth, hak, java, sql, jsp, spring;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddr() {
		return addr;
	}
	
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public int getBirth() {
		return birth;
	}
	
	public void setBirth(int birth) {
		this.birth = birth;
	}
	
	public int getHak() {
		return hak;
	}
	
	public void setHak(int hak) {
		this.hak = hak;
	}
	
	public int getJava() {
		return java;
	}
	
	public void setJava(int java) {
		this.java = java;
	}
	
	public int getSql() {
		return sql;
	}
	
	public void setSql(int sql) {
		this.sql = sql;
	}
	
	public int getJsp() {
		return jsp;
	}
	
	public void setJsp(int jsp) {
		this.jsp = jsp;
	}
	
	public int getSpring() {
		return spring;
	}
	
	public void setSpring(int spring) {
		this.spring = spring;
	}
	
	@Override
	public String toString() {
		return "학생정보 [아이디=" + id + ", 비밀번호=" + password + ", 이름=" + name + ", 주소=" + addr + ", 생년월일="
				+ birth + ", 학번=" + hak + ", 자바=" + java + ", SQL=" + sql + ", JSP=" + jsp + ", 스프링=" + spring
				+ "]\n";
	}
	
	
}