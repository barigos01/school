<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="grade_list">
	<div class="joinCenter row">
		<form action="${context}/member/member_list.do" name="grade_list" class="form-horizontal">
		<h3 style="text-align: center">회원 정보 목록</h3>
		<br/>
			<table border=1 align="center" style="width: 90%; text-align: center">
				<tr>
					<td>아이디</td>
					<td>이름</td>
					<td>비밀번호</td>
					<td>주소</td>
					<td>생년월일</td>
				</tr>
				
				<c:forEach var="member_list" items="${list}">
					<tr>
						<td>${member_list.id}</td>
						<td><a href="${context}/grade/add_form.do?id=${member_list.id}">${member_list.name}</a></td>
						<td>${member_list.password}</td>
						<td>${member_list.addr}</td>
						<td>${member_list.birth}</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
</div>
<jsp:include page="../global/footer.jsp" />