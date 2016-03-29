<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="admin_header.jsp"/>
<div class="container" style="width:1000px; margin:0 auto;">
	<div class="row display-table">
	    <div class="col-xs-12 col-sm-4 display-cell" >
		    <ul id="admin_sidebar" class="nav nav-pills nav-stacked">
		    	<li><a onclick="admin.memberList()">전체 학생 목록</a></li>
		    	<li><a onclick="admin.gradeList()">전체 성적 목록</a></li>
		    </ul>
	    </div>
	    <div class="col-xs-12 col-sm-8 display-cell" id="result" style="border: 1px solid black;height: 500px">
	        <%-- <jsp:include page="member_list.jsp"/> --%>
	    </div>
	</div>
</div>
<script src="${context}/resources/js/admin.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#result').load('${context}/admin/member_list.do');
		$('#admin_sidebar').children().first().addClass('dropdown active');
		$('#admin_sidebar').children().click(function() {
			$(this).addClass('dropdown active');
			$(this).siblings().removeClass('dropdown active');
		});
	});
	
	var admin = {
		memberList : function() {
			$('#result').load('${context}/admin/member_list.do');
		},
		gradeList : function() {
			$('#result').load('${context}/admin/grade_list.do');
		}
	};
</script>
<jsp:include page="../global/footer.jsp"/>