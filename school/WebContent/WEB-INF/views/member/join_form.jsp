<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="context" value="<%=request.getContextPath()%>"></c:set>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
	<form name="join" action="${context}/member/join.do">
		회원가입 폼
		
		<table>
			<tr>
				<td>
					<h3>아이디</h3>
				</td>
				<td>
					<input type="text" name="id" autofocus="autofocus" required="required"/>
				</td>
			</tr>
			<tr>
				<td>
					<h3>비밀번호</h3>
				</td>
				<td>
					<input type="password" name="password" required="required" />
				</td>
			</tr>
			<tr>
				<td>
					<h3>비밀번호 확인</h3>
				</td>
				<td>
					<input type="password" name="check" />
				</td>
			</tr>
			<tr>
				<td>
					<h3>이름</h3>
				</td>
				<td>
					<input type="text" name="name" />
				</td>
			</tr>
			<tr>
				<td>
					<h3>생년월일</h3>
				</td>
				<td>
					<input type="text" name="birth" />
				</td>
			</tr>
			<tr>
				<td>
					<h3>주소</h3>
				</td>
				<td>
					<input type="text" name="addr"/>
				</td>
			</tr>
		</table>
		
		<div>
		<input type="submit" value="회원가입" />
		</div>
	</form>
</body>
</html>