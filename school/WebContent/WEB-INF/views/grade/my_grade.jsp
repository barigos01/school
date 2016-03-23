<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />
<div class="mg_auto" style="width: 1000px">

	<form name="my_grade">
		<table border=1>
			<tr>
				<td>과목</td>
				<td>성적</td>
			</tr>
			<tr>
				<td>자바</td>
				<td><input type="text" name="java" value="${score.java}"/></td>
			</tr>
			<tr>
				<td>JSP</td>
				<td><input type="text" name="jsp" value="${score.jsp}"/></td>
			</tr>
			<tr>
				<td>SQL</td>
				<td><input type="text" name="sql" value="${score.sql}"/></td>
			</tr>
			<tr>
				<td>스프링</td>
				<td><input type="text" name="spring" value="${score.spring}"/></td>
			</tr>
		</table>
		
	</form>
	
<%-- 	<form action="${context}/member/detail.do?id=${score.id}">
		<input type="hidden" name="id" value="${score.id}" />
		<input type="submit" value="내정보보기" />
	</form> --%>
</div>
<jsp:include page="../global/footer.jsp" />