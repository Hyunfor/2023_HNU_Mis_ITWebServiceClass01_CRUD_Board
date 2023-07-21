<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<%-- <%@include file="../include/header.jsp"%> --%>
<jsp:include page="../include/header.jsp" />

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->


		<div class="col-md-12">
			<!-- general form elements -->
			<div class='box'>
				<div class="box-header with-border">
					<h3 class="box-title">회원 관리</h3>
				</div>


				<div class='box-body'>

					<select name="searchType">
						<option value="none"
							<c:out value="${cri.searchType == null?'selected':''}"/>>
							---</option>
						<option value="i"
							<c:out value="${cri.searchType eq 'i'?'selected':''}"/>>
							회원아이디</option>
						<option value="n"
							<c:out value="${cri.searchType eq 'n'?'selected':''}"/>>
							회원명</option>
						<option value="in"
							<c:out value="${cri.searchType eq 'in'?'selected':''}"/>>
							회원아이디 OR 회원명</option>
					</select> <input type="text" name='keyword' id="keywordInput"
						value='${cri.keyword }'>
					<button id='searchBtn'>검색</button>
					<button id='newBtn'>회원 등록</button>

				</div>
			</div>


			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">회원 목록</h3>
				</div>
				<div class="box-body">
					<table class="table table-bordered">
						<tr>
						    <th style="width: 10px">NO</th>
							<th>회원아이디</th>
							<th>회원명</th>
							<th>포인트</th>
						</tr>

						<c:forEach items="${list}" var="userVO" varStatus="var">

							<tr>
								<c:if test="${pageMaker.cri.page == 1 }">
								<td>${var.count }</td>
								</c:if>
								<c:if test="${pageMaker.cri.page != 1 }">
								<td>${var.count + ((pageMaker.cri.page-1)*10) }</td>
								</c:if>
								<td><a href='/user/readPage${pageMaker.makeSearch(pageMaker.cri.page) }&usid=${userVO.usid}'>
										${userVO.usid} </a></td>
								<td>${userVO.uname}</td>
								<td>${userVO.upoint}</td>
							</tr>

						</c:forEach>

					</table>
				</div>
				<!-- /.box-body -->


				<div class="box-footer">

					<div class="text-center">
						<ul class="pagination">

							<c:if test="${pageMaker.prev}">
								<li><a
									href="list${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
							</c:if>

							<c:forEach begin="${pageMaker.startPage }"
								end="${pageMaker.endPage }" var="idx">
								<li
									<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
									<a href="list${pageMaker.makeSearch(idx)}">${idx}</a>
								</li>
							</c:forEach>

							<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
								<li><a
									href="list${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
							</c:if>

						</ul>
					</div>

				</div>
				<!-- /.box-footer-->
			</div>
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->


<script>
	var result = '${msg}';

	if (result == 'SUCCESS') {
		alert("처리가 완료되었습니다.");
	}
</script>

<script>
	$(document).ready(
			function() {

				$('#searchBtn').on(
						"click",
						function(event) {

							self.location = "list"
									+ '${pageMaker.makeQuery(1)}'
									+ "&searchType="
									+ $("select option:selected").val()
									+ "&keyword=" + $('#keywordInput').val();

						});

				$('#newBtn').on("click", function(evt) {

					self.location = "register";

				});

			});
</script>

<%@include file="../include/footer.jsp"%>
