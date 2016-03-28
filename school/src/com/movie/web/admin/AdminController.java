package com.movie.web.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.web.global.Command;
import com.movie.web.global.CommandFactory;
import com.movie.web.global.DispatcherServlet;
import com.movie.web.global.Seperator;
import com.movie.web.grade.GradeMemberBean;

/**
 * Servlet implementation class AdminController
 */
@WebServlet({"/admin/admin_form.do", "/admin/admin_login_form.do","/admin/admin_login.do"})
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminService service = AdminServiceImpl.getInstance();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Command command = new Command();
		AdminBean admin = new AdminBean();
		GradeMemberBean gm = new GradeMemberBean();
		HttpSession session = request.getSession();
		
		System.out.println("***** 관리자에서 들어옴 *****");
		
		String[] str = Seperator.doSomething(request);
		
		switch (str[1]) {
		case "admin_login_form":
			System.out.println(" = 관리자 로그인 폼 = ");
			command = CommandFactory.createCommand(str[0], "admin_login_form");
			break;
		
		case "admin_login":
			System.out.println(" = 로그인 = ");
			admin = service.selectAdmin(request.getParameter("id"), request.getParameter("password"));
			
			if (admin == null) {
				command = CommandFactory.createCommand(str[0],"admin_login_form");
			} else {
				System.out.println("로그인 성공");
				request.setAttribute("admin", admin);
				session.setAttribute("user", admin);
				command = CommandFactory.createCommand(str[0],"admin_form");
			}
			break;
			
		case "admin_form":
			System.out.println(" = 관리자 목록 = ");
			command = CommandFactory.createCommand(str[0], "admin_form");
			break;
			
		case "member_list":
			System.out.println(" = 학생 정보 목록 = ");
			request.setAttribute("list", service.getMemberList());
			command = CommandFactory.createCommand(str[0], "admin_form");
			break;
			
		case "grade_list":
			System.out.println(" = 학생 성적 목록 = ");
			request.setAttribute("admin", service.getMemberList());
			command = CommandFactory.createCommand(str[0], "grade_list");
			break;

		default:
			break;
		}
		
		System.out.println("action= " + str[1]);
		DispatcherServlet.dispatcher(request, response, command.getView());
	}

}
