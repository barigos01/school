<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="member_header.jsp"/>
<div id="detail">
		<div class="joinTop">
			<h2 class="text-center">${sessionScope.user.name} 회원 수정 정보</h2>
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
							<input type="text" class="form-control" id="password" name="password" value="${sessionScope.user.password}"/>
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
							<input type="text" class="form-control" id="addr" name="addr" value="${sessionScope.user.addr}"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">생년월일</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="birth" name="birth" value="${sessionScope.user.birth}" readonly="readonly"/>
						</div>
					</div>
					<div class="input_button text-center">
						<img src="${context}/img/member/ok.jpg" id="updateButton"/>
					</div>
						
				</fieldset>
			</form>
		</div>
	</div>
<script>
	$(function() {
		$('form').addClass('form-horizontal');
		$('#updateButton').css('width', '150px');
		$('#updateButton').click(function() {
			$('form').attr('action','${context}/member/update.do').attr('method','post').submit();
		});
	});

</script>
<jsp:include page="../global/footer.jsp" />