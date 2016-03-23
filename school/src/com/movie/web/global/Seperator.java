package com.movie.web.global;

import javax.servlet.http.HttpServletRequest;

public class Seperator {
	public static String[] doSomething(HttpServletRequest request){
		String path = request.getServletPath();
		String temp = path.split("/")[2]; // login_form.do 또는 join_form.do
		String directory = path.split("/")[1]; // member
		String action = temp.split("\\.")[0]; // login_form 또는 join_form
		String id = "", password = "";
		
		String[] arr = new String[2];
		arr[0] = directory;
		arr[1] = action;
		
		return arr;
	}
}
