<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<table>
		<tr>
			<td colspan="5" align="right"><a href="input">글쓰기</a>
		</tr>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${list}" var="board">
			<tr>
				<td>${board.bno}</td>
				<td><a ="read" href="${board.bno}">${board.title}</a></td>
				<td>${board.writer}</td>
				<td>${board.regdate}</td>
				<td>${board.readcount}</td>
			</tr>
		</c:forEach>
		<tr>
			<td id="pagenate" colspan="5" align="center"><c:if test="${pageMaker.prev}">
					<a href="${pageMaker.startPage-1}">이전</a>
				</c:if> <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="i">
					<c:choose>
						<c:when test="${pageMaker.cri.page==i}">${i}</c:when>
						<c:otherwise>
							<a href="${i}">${i}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach> <c:if test="${pageMaker.next}">
					<a href="${pageMaker.endPage+1}">다음<a>
				</c:if></td>
		</tr>
	</table>
	<form id="jobForm">
		<input type="hidden" name="page" value="${pageMaker.cri.page}"> <input type="hidden" name="perPageNum" value="${pageMaker.cri.perPageNum}">
	</form>
	<script type="text/javascript">
		var jobForm = $('#jobForm');

		$('#pagenate a').on('click', function(event) {
			// 원래 a 링크 클릭을 막는다
			event.preventDefault();

			//$(this) = 내가 이벤트 준 것
			var targetPage = $(this).attr('href');

			jobForm.find("[name='page']").val(targetPage);
			jobForm.attr('action', '/list').attr('method', 'get');
			jobForm.submit();
		});

		$('#read').on(
				'click',
				function(event) {
					event.preventDefault();
					jobForm.append("<input type='hidden' name='bno' value='"
							+ $(this).attr("href") + "'>");
					jobForm.attr('action', '/update').attr('method', 'get');
					jobForm.submit();
				});

	</script>
</body>
</html>