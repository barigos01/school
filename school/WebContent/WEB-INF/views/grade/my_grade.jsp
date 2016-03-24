<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />
<div id="detail">
		<div class="detailTop">
			<h2 class="text-center">회원 상세 정보</h2>
		</div>
		<div class="joinCenter row">
			<form action="${context}/member/update_form.do" name="updateForm" class="form-horizontal">
				<fieldset class="joinField">
					<div class="form-group">
					 	<label for="input_id" class="col-sm-4 control-label">자바</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" name="java" value="${score.java}" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_pw" class="col-sm-4 control-label">JSP</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" name="jsp" value="${score.jsp}"readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">SQL</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" name="sql" value="${score.sql}" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">스프링</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" name="spring" value="${score.spring}" readonly="readonly"/>
						</div>
					</div>
				</fieldset>
			</form>
	</div>
</div>

<jsp:include page="../global/footer.jsp" />