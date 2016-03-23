package com.movie.web.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.web.global.Command;
import com.movie.web.global.CommandFactory;
import com.movie.web.global.DispatcherServlet;
import com.movie.web.global.Seperator;

import sun.rmi.server.Dispatcher;

@WebServlet({ "/member/login_form.do", "/member/join_form.do", "/member/join.do", "/member/login.do", "/member/update_form.do", "/member/update.do", "/member/delete.do" }) // web.xml
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberService service = MemberServiceImpl.getInstance();

	// 페이지 이동시에는 doGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Command command = new Command();
		MemberBean member = new MemberBean();
		
		System.out.println("***** 인덱스에서 들어옴 *****");

		String[] str = Seperator.doSomething(request);
		
		switch (str[1]) {
		case "login":
			System.out.println(" = 로그인 = ");
			System.out.println(">>" + service.isMember(request.getParameter("id")));
			
			if (service.isMember(request.getParameter("id")) == true) {
				member = service.login(request.getParameter("id"), request.getParameter("password"));
				
				if (member == null) {
					command = CommandFactory.createCommand(str[0],"login_form");
				}else{
					System.out.println("로그인 성공");
					request.setAttribute("member", member);
					command = CommandFactory.createCommand(str[0],"detail");
				}
			} else {
				command = CommandFactory.createCommand(str[0], "login_form");
			}
			break;
			
		case "update_form":
			System.out.println("=== 수정 폼으로 진입 ===");
			request.setAttribute("member", service.detail(request.getParameter("id")));
			command = CommandFactory.createCommand(str[0], str[1]);
			break;
			
		case "delete" : 
			if (service.remove(request.getParameter("id")) == 1) {
				command = CommandFactory.createCommand(str[0], "login_form");
			} else {
				request.setAttribute("member", service.detail(request.getParameter("id")));
				command = CommandFactory.createCommand(str[0], "detail");
			}
			break;

		default:
			command = CommandFactory.createCommand(str[0], str[1]);
			break;
		}

		System.out.println("action =" + str[1]);
		
		DispatcherServlet.dispatcher(request, response, command.getView());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Command command = new Command();
		MemberBean member = new MemberBean();
		String[] str = Seperator.doSomething(request);
		
		switch (str[1]) {
		case "join":
			member.setId(request.getParameter("id"));
			member.setName(request.getParameter("name"));
			member.setPassword(request.getParameter("password"));
			member.setAddr(request.getParameter("addr"));
			member.setBirth(Integer.parseInt(request.getParameter("birth")));
			
			if (service.join(member) == 1) {
				command = CommandFactory.createCommand(str[0],"login_form");
			} else {
				command = CommandFactory.createCommand(str[0],"join_form");
			}
			break;
			
		case "update":
			member.setId(request.getParameter("id"));
			member.setName(request.getParameter("name"));
			member.setPassword(request.getParameter("password"));
			member.setAddr(request.getParameter("addr"));
			member.setBirth(Integer.parseInt(request.getParameter("birth")));
			
			if (service.update(member)==1) {
				request.setAttribute("member", service.detail(request.getParameter("id")));
				command = CommandFactory.createCommand(str[0],"detail");
			}else{
				request.setAttribute("member", service.detail(request.getParameter("id")));
				command = CommandFactory.createCommand(str[0],"update_form");
			}
			break;
		}
		
		
		DispatcherServlet.dispatcher(request, response, command.getView());
	}

}