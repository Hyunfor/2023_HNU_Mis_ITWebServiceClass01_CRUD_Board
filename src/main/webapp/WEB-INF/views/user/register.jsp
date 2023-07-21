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
					<h3 class="box-title">회원 등록하기</h3>
				</div>
				<!-- /.box-header -->

				<form role="form" method="post">
					<div class="box-body">
						<div class="form-group">
							<label for="exampleInputEmail1">회원 아이디</label> <input type="text"
								name='usid' class="form-control" placeholder="Enter ID">
						</div>
						
						<div class="form-group">
							<label for="exampleInputEmail1">회원 비밀번호</label> <input type="password"
								name='upw' class="form-control" placeholder="Enter pw">
						</div>
						
						<div class="form-group">
							<label for="exampleInputEmail1">이름</label> <input type="text"
								name='uname' class="form-control" placeholder="Enter Name">
						</div>
						
 						<div class="form-group">
							<label for="exampleInputEmail1">포인트</label> <input type="text"
								name="upoint" class="form-control" placeholder="Enter Point">
						</div> 
					</div>
					<!-- /.box-body -->

					<div class="box-footer">
						<button type="submit" class="btn btn-primary">등록</button>
					</div>
				</form>

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
