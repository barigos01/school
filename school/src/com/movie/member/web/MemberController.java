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

@WebServlet({"/member/login_form.do","/member/join_form.do","/member/join.do"}) //web.xml
public class MemberController extends HttpServlet {
   private static final long serialVersionUID = 1L;

   // 페이지 이동시에는 doGet
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
         System.out.println("인덱스에서 들어옴");
         String path = request.getServletPath();
         String temp = path.split("/")[2];		// login_form 또는 join_form
         
         String directory= path.split("/")[1];	// member
         String action= temp.split("\\.")[0];
         if (action.equals("join")) {
			String id = request.getParameter("id");
			System.out.println("아이디 = " + id);
		}
         
         
         System.out.println("action =" + action);
         //arr[1] = temp3.substring(0, temp3.indexOf("."));
         Command command = CommandFactory.createCommand(directory, action);
         
         switch (command.getAction()) {
         case "login_form":
            RequestDispatcher dis = request.getRequestDispatcher(CommandFactory.getCommand(request, response).getView());
            dis.forward(request, response);
            break;
         case "join_form":
            RequestDispatcher dis2 = request.getRequestDispatcher(CommandFactory.getCommand(request, response).getView());
            dis2.forward(request, response);
            break;
         
         default:
            break;
         }
      //   RequestDispatcher dis = request.getRequestDispatcher(new Command(doProc(request, response)[0], doProc(request, response)[1]).getView());
         
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

   }

}