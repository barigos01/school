<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="default_header.jsp" />
<div class="mg_auto">
	<center>
		<img src="${context}/img/main/hanbit.jpg" alt="" height="500px"/>
	</center>
	<br>

<div style="margin-left: 43.5%">
	<div>
		<h4><a href="${context}/member/login_form.do">로그인 이동</a></h4>
		<h4><a href="${context}/member/join_form.do">회원가입 이동</a></h4>
		<h4><a href="${context}/admin/login_form.do">관리자 이동</a></h4>
	</div>
</div>
<jsp:include page="footer.jsp" />
</div>