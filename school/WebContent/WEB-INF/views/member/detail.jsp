<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp"/>
<div id="detail">
		<div class="detailTop">
			<h2 class="text-center">회원 상세 정보</h2>
		</div>
		<div class="joinCenter row">
			<form action="${context}/member/update_form.do" name="updateForm" class="form-horizontal">
				<fieldset class="joinField">
					<div class="form-group">
					 	<label for="input_id" class="col-sm-4 control-label">아이디</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="id" name="id" value="${member.id}" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_pw" class="col-sm-4 control-label">비밀번호</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="password" name="password" value="${member.password}" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">이름</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="name" name="name" value="${member.name}" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">주소</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="addr" name="addr" value="${member.addr}" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">생년월일</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="birth" name="birth" value="${member.birth}" readonly="readonly"/>
						</div>
					</div>
					<div class="input_button text-center">
						<input type="submit" id="updateButton" class="btn btn-primary" value ="수정"/>
					</div>
						
				</fieldset>
			</form>
			
			<div class="input_button text-center">
			<form action="${context}/grade/my_grade.do?id=${member.id}">
				<input type="hidden" name="id" value="${member.id}" />
				<input type="submit" class="btn btn-primary" value="내성적보기" />
			</form>
			<form action="${context}/member/delete.do?id=${member.id}">
				<input type="hidden" name="id" value="${member.id}" />
				<input type="submit" class="btn btn-primary" value="회원탈퇴" />
			</form>
			<form action="${context}/global/main.do">
				<input type="submit" class="btn btn-primary" value="로그아웃" />
			</form>
			</div>
		</div>
	</div>
<jsp:include page="../global/footer.jsp" />