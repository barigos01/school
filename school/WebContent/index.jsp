<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="context" value="<%=request.getContextPath()%>"></c:set>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>메인화면</title>
</head>
<body>
	<a href="${context}/member/login_form.do">로그인 이동</a><br>
	<a href="${context}/member/join_form.do">회원가입 이동</a><br>
	<a href="${context}/grade/grade_list.do">관리자 이동</a>
</body>
</html>
