package com.movie.web.jQeury;

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
import com.movie.web.member.MemberBean;

@WebServlet({"/jquery/attr.do", "/jquery/core.do", "/jquery/dom.do", "/jquery/event.do", 
				"/jquery/selector.do", "/jquery/traversing.do"})
public class JQueryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Command command = new Command();
		String[] str = Seperator.doSomething(request);			// str[0] : directory, str[1] : action
		command = CommandFactory.createCommand(str[0], str[1]);

		System.out.println("action= " + str[1]);
		
		DispatcherServlet.dispatcher(request, response, command.getView());
	}

}
