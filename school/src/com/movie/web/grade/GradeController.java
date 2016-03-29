package com.movie.web.grade;

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
import com.movie.web.member.MemberService;
import com.movie.web.member.MemberServiceImpl;

/**
 * Servlet implementation class GradeController
 */
@WebServlet({"/grade/my_grade.do", "/grade/add_form.do", "/grade/grade_add.do"})
public class GradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GradeService service = GradeServiceImpl.getInstance();
	MemberService mservice = MemberServiceImpl.getInstance();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Command command = new Command();
		GradeBean grade = new GradeBean();
		System.out.println("***** 그레이드에서 들어옴 *****");
		
		String path = request.getServletPath();
		String temp = path.split("/")[2];	// main.do
		String directory = path.split("/")[1];	// global
		String action = temp.split("\\.")[0];	// main
		
		switch (action) {
		case "my_grade":
			System.out.println(" = 성적보기 = ");
			request.setAttribute("score", service.selectGradeById(request.getParameter("id")));
			command = CommandFactory.createCommand(directory, "my_grade");
			break;
			
		case "add_form":
			System.out.println(" = 성적입력폼 = ");
			request.setAttribute("memberName", mservice.detail(request.getParameter("id")));
			command = CommandFactory.createCommand(directory, "grade_add");
			break;
		
		case "grade_add":
			System.out.println(" = 성적입력 = ");
			grade.setId(request.getParameter("id"));
			grade.setJava(Integer.parseInt(request.getParameter("java")));
			grade.setJsp(Integer.parseInt(request.getParameter("jsp")));
			grade.setSql(Integer.parseInt(request.getParameter("sql")));
			grade.setSpring(Integer.parseInt(request.getParameter("spring")));
			
			if (service.insertGrade(grade) == 1) {
				command = CommandFactory.createCommand("admin","admin_form");
			}

			break;
		default:
			command = CommandFactory.createCommand(directory, action);
			break;
		}

		System.out.println("action =" + action);

		DispatcherServlet.dispatcher(request, response, command.getView());
	}
}
