package com.movie.member.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.web.global.Command;
import com.movie.web.global.CommandFactory;

@WebServlet({ "/member/login_form.do", "/member/join_form.do", "/member/join.do", "/member/login.do" }) // web.xml
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 페이지 이동시에는 doGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Command command = new Command();
		MemberService service = new MemberServiceImpl();
		
		System.out.println("인덱스에서 들어옴");		
		
		String path = request.getServletPath();
		String temp = path.split("/")[2]; // login_form.do 또는 join_form.do
		String directory = path.split("/")[1]; // member
		String action = temp.split("\\.")[0]; // login_form 또는 join_form
		String id = "", password = "";

		switch (action) {
		case "join":
			id = request.getParameter("id");
			System.out.println("아이디 = " + id);
			break;
		case "login":
			System.out.println(" = 로그인 = ");
			System.out.println(">>" + service.isMember(request.getParameter("id")));
			if (service.isMember(request.getParameter("id")) == true) {
				service.login(request.getParameter("id"), request.getParameter("password"));
				command = CommandFactory.createCommand(directory, "detail");
			} else {
				command = CommandFactory.createCommand(directory, "login_form");
			}
			
			break;

		default:
			command = CommandFactory.createCommand(directory, action);
			break;
		}

		System.out.println("action =" + action);

		RequestDispatcher dis = request
				.getRequestDispatcher(command.getView());
		dis.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}