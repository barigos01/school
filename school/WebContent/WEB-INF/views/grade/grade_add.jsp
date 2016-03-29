<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../admin/admin_header.jsp"/>
<c:set var="member_list" value="${list}" />
<h3>${memberName.name} 성적 입력</h3>
<form>
	<div class="joinCenter row">
		<h3 style="text-align: center">회원 정보 목록</h3>
		<input type="hidden" id="id" name="id" value="${memberName.id}"/>
		<br/>
		<table border=1 align="center" style="width: 90%; text-align: center">
			<tr>
				<td>JAVA</td>
				<td>JSP</td>
				<td>SQL</td>
				<td>SPRING</td>
			</tr>
			
			<tr>
				<td><input type="text" id="java" name="java" /></td>
				<td><input type="text" id="jsp" name="jsp" /></td>
				<td><input type="text" id="sql" name="sql" /></td>
				<td><input type="text" id="java" name="spring" /></td>
			</tr>
			
			<tr>
				<td colspan="4">
					<button id="grade_input">입력</button>
					<button id="grade_cancle">취소</button>
				</td>
			</tr>
		</table>
	</div>
</form>
<script>
	$(function() {
		$('#grade_input').click(function() {
			$('form').attr('action','${context}/grade/grade_add.do').attr('method', 'post').submit();
		});
		
		$('#grade_cancle').click(function() {
			$('form').reset();
		});
	});
</script>