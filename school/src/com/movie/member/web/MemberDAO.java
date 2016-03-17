package com.movie.member.web;

public interface MemberDAO {
	public void insert(MemberBean member);
	public void selectById(String id, String password);
	public MemberBean selectMember(String id);
	public void update(MemberBean member);
	public MemberBean delete(String id);
}
