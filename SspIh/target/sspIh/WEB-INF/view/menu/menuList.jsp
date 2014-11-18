<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/include.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Welcome to Spring World!</title>
</head>
<body>
	<a href="<c:url value="/menu/menuForm.do" />">[메뉴 추가]</a>

	<h2>현재 등록된 메뉴 정보는 다음과 같습니다.</h2>
	<hr />

	<table border="0">
		<thead>
			<tr>
				<td>메뉴 ID</td>
				<td>메뉴 이름</td>
				<td>메뉴 가격</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="menu" items="${menuList}">
			<tr>
				<td><a href="<c:url value="/menu/viewMenu.web?menuId=${menuVO.menuId}"/>">${menuVO.menuId }</a></td>
				<td>${menuVO.menuName }</td>
				<td>${menuVO.menuPrice }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>