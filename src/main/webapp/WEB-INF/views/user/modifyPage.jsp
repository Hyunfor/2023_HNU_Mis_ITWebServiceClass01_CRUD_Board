<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- <%@include file="../include/header.jsp"%> --%>
<jsp:include page="../include/header.jsp" />
<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">회원 정보 수정하기</h3>
				</div>
				<!-- /.box-header -->

<form role="form" action="modifyPage" method="post">

	<input type='hidden' name='page' value="${cri.page}"> 
	<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
	<input type='hidden' name='searchType' value="${cri.searchType}">
	<input type='hidden' name='keyword' value="${cri.keyword}">

					<div class="box-body">

						<div class="form-group">
							<label for="exampleInputEmail1">회원 아이디</label> 
							<input type="text" name='usid' class="form-control" value="${userVO.usid}" readonly="readonly">
						</div>
					<div class="form-group">
						<label for="exampleInputEmail1">비밀번호</label> 
						<input type="text" name='upw' class="form-control" value="${userVO.upw}">
					</div>						
					<div class="form-group">
						<label for="exampleInputEmail1">회원명</label> 
						<input type="text" name='uname' class="form-control" value="${userVO.uname}">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">포인트</label> 
						<input type="text" name='upoint' class="form-control" value="${userVO.upoint}">
					</div>					
					</div>
					<!-- /.box-body -->
				</form>
				<div class="box-footer">
					<button type="submit" class="btn btn-primary">저장</button>
					<button type="submit" class="btn btn-warning">취소</button>
				</div>


<script>
$(document).ready(
	function() {

		var formObj = $("form[role='form']");

		console.log(formObj);

		$(".btn-warning")
				.on("click",function() {
					self.location = "/user/list?page=${cri.page}&perPageNum=${cri.perPageNum}"
							+ "&searchType=${cri.searchType}&keyword=${cri.keyword}";
				});

		$(".btn-primary").on("click",
				function() {
					formObj.submit();
				});
	});
</script>

			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<%@include file="../include/footer.jsp"%>
