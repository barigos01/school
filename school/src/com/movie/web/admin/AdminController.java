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
@WebServlet({"/admin/admin_form.do", "/admin/login_form.do", "/admin/login.do", "/admin/member_list.do", 
				"/admin/grade_list.do"})
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
		case "login_form":
			System.out.println(" = 관리자 로그인 폼 = ");
			command = CommandFactory.createCommand(str[0], "login_form");
			break;
		
		case "login" :
			System.out.println("관리자 로그인 진입");
			admin.setId(request.getParameter("id"));
			admin.setPassword(request.getParameter("password"));
			AdminBean temp = service.selectAdmin(admin);
			
			if (temp.getId() == null) {
				System.out.println("관리자 로그인 실패");
				command = CommandFactory.createCommand(str[0], "login_form");
			} else {
				System.out.println("관리자 로그인 성공");
				session.setAttribute("admin", temp);
				command = CommandFactory.createCommand(str[0], "admin_form");
			}
			break;
			
		case "admin_form":
			System.out.println(" = 관리자 목록 = ");
			command = CommandFactory.createCommand(str[0], "admin_form");
			break;
			
		case "member_list":
			System.out.println(" = 학생 정보 목록 = ");
			request.setAttribute("list", service.getMemberList());
			command = CommandFactory.createCommand(str[0], "member_list");
			break;
			
		case "grade_list":
			System.out.println(" = 학생 성적 목록 = ");
			request.setAttribute("admin", service.getGradeList());
			command = CommandFactory.createCommand(str[0], "grade_list");
			break;

		default:
			break;
		}
		
		System.out.println("action= " + str[1]);
		DispatcherServlet.dispatcher(request, response, command.getView());
	}

}
