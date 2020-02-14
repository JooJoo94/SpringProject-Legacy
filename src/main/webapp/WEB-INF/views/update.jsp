<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/update" method="post">
<input type="hidden" name="page" value="${cri.page}"/>
<input type="hidden" name="perPageNum" value="${cri.perPageNum}"/>
<input type="hidden" name="bno" value="${board.bno}"/>
<table>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" value="${board.title}"></td>
			<th>내용</th>
			<td><textarea rows="5" cols="50" name="content">${board.content}</textarea></td>
			<th>작성자</th>
			<td><input type="text" name="writer" value="${board.writer}"></td>
		</tr>
		<tr>
		<td colspan="2" align="center">
		<input type="submit" value="저장"/>
		<input type="reset" value="취소"/>
		<input type="button" value="삭제" onclick="location.href='delete?bno=${board.bno}'"/>		
		<input type="button" value="목록보기" onclick="location.href='list'"/>	
					
		</td>
		</tr>
		
	</table>
</form>
	<form id="jobForm">
		<input type="hidden" name="page" value="$cri.page}"> 
		<input type="hidden" name="perPageNum" value="${cri.perPageNum}">
	</form>
	<script type="text/javascript">
		var jobForm = $('#jobForm');

		$('#list').on('click', function(event) {
			// 원래 a 링크 클릭을 막는다
			event.preventDefault();

			//$(this) = 내가 이벤트 준 것
			var targetPage = $(this).attr('href');

			jobForm.find("[name='page']").val(targetPage);
			jobForm.attr('action', '/list').attr('method', 'get');
			jobForm.submit();
		});

		$('.read').on('click', function(event) {
					event.preventDefault();
					jobForm.append("<input type='hidden' name='bno' value='"
							+ $(this).attr("href") + "'>");
					jobForm.attr('action', '/update').attr('method', 'get');
					jobForm.submit();
				});
	</script>
</body>
</html>