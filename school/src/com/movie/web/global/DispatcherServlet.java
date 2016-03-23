package com.movie.web.global;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet {
	public static void dispatcher(HttpServletRequest request, HttpServletResponse response, String view) {
		RequestDispatcher dis = request.getRequestDispatcher(view);
		
		try {
			dis.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
