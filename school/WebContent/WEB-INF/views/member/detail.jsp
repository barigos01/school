<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="member_header.jsp"/>
<div id="detail">
		<div class="detailTop">
			<h2 class="text-center">${sessionScope.user.name} 회원 상세 정보</h2>
		</div>
		<div class="joinCenter row">
			<form>
				<fieldset class="joinField">
					<div class="form-group">
					 	<label for="input_id" class="col-sm-4 control-label">아이디</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="id" name="id" value="${sessionScope.user.id}" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_pw" class="col-sm-4 control-label">비밀번호</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="password" name="password" value="${sessionScope.user.password}" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">이름</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="name" name="name" value="${sessionScope.user.name}" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">주소</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="addr" name="addr" value="${sessionScope.user.addr}" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">생년월일</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="birth" name="birth" value="${sessionScope.user.birth}" readonly="readonly"/>
						</div>
					</div>
				</fieldset>
			</form>
			
			<div class="input_button text-center">
				<img src="${context}/img/member/update.jpg" id="updateButton"/>
				<img src="${context}/img/member/score.jpg" id="scoreButton"/>
				<img src="${context}/img/member/withdrawal.jpg" id="withdrawalButton"/>
				<img src="${context}/img/member/logout.jpg" id="logoutButton"/>
			</div>
		</div>
	</div>
	<!--  -->
<script type="text/javascript">
	$(function() {
		$('form').addClass('form-horizontal');
		$('#updateButton').css('width', '150px');
		$('#scoreButton').css('width', '150px');
		$('#withdrawalButton').css('width', '150px');
		$('#logoutButton').css('width', '150px');
		
		$('#updateButton').click(function() {
			location.href = '${context}/member/update_form.do';
		});
		$('#scoreButton').click(function() {
			location.href = '${context}/grade/my_grade.do?id=${member.id}';
		});
		$('#withdrawalButton').click(function() {
			location.href = '${context}/member/delete.do';
		});
		$('#logoutButton').click(function() {
			location.href = '${context}/global/main.do';
		});
	});
</script>
<jsp:include page="../global/footer.jsp" />