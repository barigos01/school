package com.movie.web.global;

public class Command {
	private String directory, action, view;

	public Command() {
		// TODO Auto-generated constructor stub
	}
	
	public Command(String directory, String action) {
		this.directory = directory;
		this.action = action;
		this.view = Constants.VIEWS + "/" + directory + "/" + action + ".jsp";
	}
	
	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}
	
	
}
/**
 * URL => http://localhost:9000/school/member/login_form.do
 * 컨텍스트패스 : http://localhost:9000/school
 * WebContent : /
 * URI(get방식) : member/login_form.do?id=&password=
 * URI(post방식) : member/login_form.do
 * 쿼리스트링 구분자 : ?
 * 파라미터 구분자 : &
 * 쿼리스트링 : id=&password=
 * URI는 프로젝트 내부에서 유일한 값(ID)이여야 하며,
 * 이 URI를 분해해서 서블릿에게 명령을 내리는 구조로 이루어진다.
 * */
