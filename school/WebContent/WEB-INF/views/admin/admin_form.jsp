<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp"/>
<form>
	<table class="table-condensed" style="width: 90px; margin-left: 50px;">
		<tr>
			<td>전체 회원 목록</td>
			<td><jsp:include page="grade_list.jsp"/></td>
		</tr>
		<tr>
			<td>ID로 회원 검색</td>
			<td>
				<input type="text" id="searchById" name="searchById" />
			</td>
		</tr>
		<tr>
			<td>이름으로 회원 검색(동명이인 허용)</td>
			<td>
				<input type="text" id="searchByName" name="searchByName" />
			</td>
		</tr>
		<tr>
			<td>회원 점수 입력</td>
			<td></td>
		</tr>
		
	</table>

</form>
<jsp:include page="../global/footer.jsp"/>