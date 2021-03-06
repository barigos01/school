package com.movie.web.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.web.global.Command;
import com.movie.web.global.CommandFactory;
import com.movie.web.global.DispatcherServlet;
import com.movie.web.global.Seperator;
import com.movie.web.grade.GradeMemberBean;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/grade/grade_list.do")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminService service = AdminServiceImpl.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Command command = new Command();
		GradeMemberBean gm = new GradeMemberBean();
		
		System.out.println("***** 관리자에서 들어옴 *****");
		
		String[] str = Seperator.doSomething(request);
		
		switch (str[1]) {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
