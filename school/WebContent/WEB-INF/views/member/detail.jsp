<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />
<div>
	<table border=1>
		<tr>
			<td rowspan=4></td>
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
		<td rowspan=2><input type="file" name="file"></td>
			<td>
				<h3>주소</h3>
			</td>
			
			<td>
				<input type="text" name="addr"/>
			</td>
		</tr>
		
	</table>
	
	<form action="${context}/grade/my_grade.do">
		<input type="submit" value="내성적보기" />
	</form>
	
	<form action="${context}/global/main.do">
		<input type="submit" value="로그아웃" />
	</form>
</div>
<jsp:include page="../global/footer.jsp" />