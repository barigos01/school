package com.movie.web.global;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeController
 */
@WebServlet({"/global/main.do"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Command command = new Command();
		System.out.println("디테일에서 들어옴");
		
		String path = request.getServletPath();
		String temp = path.split("/")[2];	// main.do
		String directory = path.split("/")[1];	// global
		String action = temp.split("\\.")[0];	// main
		
		switch (action) {
		case "main":
			command = CommandFactory.createCommand(directory, "main");
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
