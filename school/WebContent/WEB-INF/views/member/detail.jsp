<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
	<table>
		<tr>
			<td rowspan=4></td>
			<td><input type="file" name="file"></td>
		</tr>
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
</body>
</html>