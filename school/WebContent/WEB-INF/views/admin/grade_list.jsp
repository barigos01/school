<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="grade_list">
	<div class="joinCenter row">
		<form action="${context}/grade/grade_list.do" name="grade_list" class="form-horizontal">
			<table border=1 width="800px" align="center">
				<tr>
					<td>시험번호</td>
					<td>아이디</td>
					<td>이름</td>
					<td>자바</td>
					<td>SQL</td>
					<td>JSP</td>
					<td>스프링</td>
				</tr>
				
				<c:forEach var="score_list" items="${admin}">
					<tr>
						<td>${score_list.score_seq}</td>
						<td>${score_list.id}</td>
						<td>${score_list.name}</td>
						<td>${score_list.java}</td>
						<td>${score_list.sql}</td>
						<td>${score_list.jsp}</td>
						<td>${score_list.spring}</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
</div>
<jsp:include page="../global/footer.jsp" />