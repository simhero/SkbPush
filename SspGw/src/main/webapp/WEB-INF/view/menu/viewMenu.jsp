<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/include.jsp" %>

<c:if test="${ex != null}">
	<script type="text/javascript">
	<!--
		alert(${e.message});
	//-->
	</script>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Welcome to Spring World!</title>
</head>
<body>
	<a href="<c:url value="/menu/menuList.do" />">목록으로...</a>
	<h2>메뉴 정보는 다음과 같습니다.</h2>
	<hr />

	<table border="0">
		<tr>
			<td>메뉴 ID : </td>
			<td>${menuVO.menuId }</td>
		</tr>
		<tr>
			<td>메뉴 이름 : </td>
			<td>${menuVO.menuName }</td>
		</tr>
		<tr>
			<td>메뉴 가격 : </td>
			<td>${menuVO.menuPrice }</td>
		</tr>
	</table>
</body>
</html>