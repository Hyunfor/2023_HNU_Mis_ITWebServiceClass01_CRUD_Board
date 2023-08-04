<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../include/header.jsp" />

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->


		<div class="col-md-12">
			<!-- general form elements -->
			<div class='box'>
				<div class="box-header with-border">
					<h3 class="box-title">공지사항 관리</h3>
				</div>
				<div class='box-body'>
					<select name="searchType">
						<option value="nn"
							<c:out value="${cri.searchType == 'nn'?'selected':''}"/>>
							전체</option>
						<option value="t"
							<c:out value="${cri.searchType eq 't'?'selected':''}"/>>
							제목</option>
						<option value="c"
							<c:out value="${cri.searchType eq 'c'?'selected':''}"/>>
							내용</option>
					</select>
				</div>

				<input type="text" name='keyword' id="keywordInput"
					value='${cri.keyword }'>
				<button id='searchBtn'>검색</button>
				<button id='newBtn'>공지사항 등록</button>
			</div>
		</div>

	</div>
	<!-- end col-->
	<div class="box">
		<div class="box-header with-border">
			<h3 class="box-title">회원 목록</h3>
		</div>
		<div class="box-body">
			<table class="table table-bordered">
				<tr>
					<th>NO</th>
					<th colspan="3">제목</th>
					<th>작성일자</th>
					<th>작성자</th>
				</tr>
				<tbody>
					<c:if test="${!empty list}">
						<c:forEach items="${list}" var="nVo" varStatus="status">
							<tr>
								<c:if test="${pageMaker.cri.page==1}">
									<td>${status.count}</td>
								</c:if>
								<c:if test="${pageMaker.cri.page!=1}">
									<td>${status.count + ((pageMaker.cri.page-1)*10)}</td>
								</c:if>

								<td colspan="3"><a
									href='read${pageMaker.makeSearch(pageMaker.cri.page)}&noticeNo=${nVo.noticeNo}'>
										${nVo.title}</a></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${nVo.regDate}" /></td>
								<td>${nVo.register}</td>

							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${empty list}">
						<tr>
							<td colspan="6">내역이 없습니다.</td>
						</tr>
					</c:if>

				</tbody>
			</table>
		</div>
	</div>
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
</section>

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