<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fmt2" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="../include/header.jsp" />

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">공지사항 상세보기</h3>
				</div>
				<!-- /.box-header -->


				<form role="form" action="modify" method="post">
					<input type='hidden' name='noticeNo' value="${noticeVO.noticeNo}">
					<input type='hidden' name='page' value="${cri.page}"> <input
						type='hidden' name='perPageNum' value="${cri.perPageNum}">
					<input type='hidden' name='searchType' value="${cri.searchType}">
					<input type='hidden' name='keyword' value="${cri.keyword}">

					<div class="row">
						<div class="col-12">

							<div class="card">
								<div class="card-body">
									<h4 class="header-title">공지사항 상세보기</h4>
									<div class="form-group col-xs-12">
										<label for="inputAddress2" class="col-form-label">제목<span
											class="must-mark">*</span></label> <input type="text" name="title"
											id="title" value="${noticeVO.title}" class="form-control"
											disabled="disabled">
									</div>

									<div class="form-row">
										<div class="form-group col-md-6">
											<label for="inputEmail4" class="col-form-label">작성자</label> <input
												type="text" name="register" id="register"
												value="${noticeVO.register}" class="form-control"
												disabled="disabled">
										</div>

										<div class="form-group col-md-6">
											<label for="inputPassword4" class="col-form-label">작성일자</label>
											<input type="text" class="form-control date" name="regDate"
												id="regDate" data-single-date-picker="true"
												value="<fmt:formatDate value="${noticeVO.regDate}" pattern="MM/dd/yyyy"/>"
												disabled="disabled">
										</div>
									</div>



									<div class="form-group">
										<label for="inputAddress2" class="col-form-label">상세내용</label>
										<textarea class="form-control" name="content" id="content"
											rows="15" disabled="disabled">${noticeVO.content}</textarea>
									</div>


									<c:if test="${!empty noticeFileVO}">
										<div class="form-group">
											<label for="exampleInputEmail1" class="col-form-label">첨부파일</label>
										</div>

										<ul class="dropzone-previews">

											<c:forEach items="${noticeFileVO}" var="noticeFileVO"
												varStatus="status">
												<c:set var="noticeFileName"
													value="${noticeFileVO.noticeFileName}" />
												<c:set var="noticeFileNo"
													value="${fn:toLowerCase(noticeFileName)}" />

												<li class="dropzone-previews mt-3">
													<div
														class="card mt-1 mb-0 shadow-none border dz-processing dz-image-preview dz-success dz-complete">
														<div class="p-2">
															<div class="row align-items-center">
																<c:forTokens var="token" items="${noticeFileNo}"
																	delims="." varStatus="status">
																	<c:if test="${status.last}">
																		<c:choose>
																			<c:when test="${token eq 'hwp'}">
																				<img data-dz-thumbnail=""
																					class="avatar-sm rounded bg-light"
																					src="/resources/dist/img/hwp.png"
																					alt="${noticeFileName}" />
																			</c:when>
																			<c:when test="${token eq 'xls' || token eq 'xlsx' }">
																				<img data-dz-thumbnail=""
																					class="avatar-sm rounded bg-light"
																					src="/resources/dist/img/excelIcon.png" />
																			</c:when>
																			<c:when
																				test="${token eq 'jpg' || token eq 'gif' || token eq 'png' || token eq 'bmp' }">
																				<img data-dz-thumbnail=""
																					class="avatar-sm rounded bg-light"
																					src="/displayFile?fileName=${noticeFileVO.fileLocation}">
																			</c:when>
																			<c:when test="${token eq 'pdf'}">
																				<img data-dz-thumbnail=""
																					class="avatar-sm rounded bg-light"
																					src="/resources/dist/img/pdf.png"
																					alt="${noticeFileName}" />
																			</c:when>
																			<c:when test="${token eq 'ppt' }">
																				<img data-dz-thumbnail=""
																					class="avatar-sm rounded bg-light"
																					src="/resources/dist/img/ppt.png"
																					alt="${noticeFileName}" />
																			</c:when>
																			<c:otherwise>
																				<img data-dz-thumbnail=""
																					class="avatar-sm rounded bg-light"
																					src="/resources/dist/img/file.svg"
																					alt="${noticeFileName}" />
																			</c:otherwise>
																		</c:choose>
																	</c:if>
																</c:forTokens>
																<div class="col pl-0">
																	<a href="/displayFile?fileName=${noticeFileVO.fileLocation}" text-muted font-weight-bold data-dz-name="">
																		${noticeFileVO.noticeFileName}</a>
																</div>
															</div>
														</div>
													</div>
												</li>
											</c:forEach>
										</ul>
									</c:if>
									<c:if test="${empty noticeFileVO}">
									</c:if>
									<br> <br>
									<div style="text-align: right;">

										<button type="button" class="btn btn-success"
											style="font-size: 14px;">수정</button>
										<button type="button" class="btn btn-light"
											style="font-size: 14px;">목록</button>
										<button class="btn btn-danger" type="submit">삭제</button>
									</div>
								</div>
							</div>
							<!-- end card -->
						</div>
						<!-- end col-12 -->
					</div>
					<!-- end row -->
				</form>
			</div>
			<!-- container -->

		</div>
		<!-- content -->

		<script>
			$(document).ready(function() {

				var formObj = $("form[role='form']");

				console.log(formObj);

				/* 수정버튼 */
				$(".btn-success").on("click", function() {
					formObj.attr("action", "/notice/modify");
					formObj.attr("method", "get");
					formObj.submit();
				});
				//목록버튼
				$(".btn-light").on("click", function() {
					formObj.attr("method", "get");
					formObj.attr("action", "/notice/list");
					formObj.submit();
				});
				/* 삭제버튼 */
				$(".btn-danger").on("click", function() {
					formObj.attr("action", "/notice/remove");
					formObj.submit();
				});

			});

			function checkImageType(fileName) {

				var pattern = /jpg|gif|png|jpeg/i;

				return noticeFileName.match(pattern);

			}
		</script>
		</div>
</section>
<!-- /.content -->

<%@include file="../include/footer.jsp"%>