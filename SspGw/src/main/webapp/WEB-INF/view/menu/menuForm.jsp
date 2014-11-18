<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/include.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Welcome to Spring World!</title>
	<c:if test="${ex != null}">
		<script type="text/javascript">
		<!--
		alert("${ex.message}");
		//-->
		</script>
	</c:if>
	<script type="text/javascript">
	function goHome(){
		location.href="<c:url value='/menu/menuForm.do'/>";
	}
	</script>
</head>
<body>
	<h2>메뉴 정보를 입력하세요</h2>
	<hr />

	<form action="<c:url value="/menu/menuForm.do"/>" method="post">
		<table border="0">
			<tr>
				<td>메뉴 이름 : </td>
				<td><input type="text" name="menuName" value="" /></td>
			</tr>
			<tr>
				<td>메뉴 가격 : </td>
				<td><input type="text" name="menuPrice" value="" /></td>
			</tr>
			<tr>
				<h4>메뉴 선택</h4>
			</tr>
			<tr>
				<td>피자 선택 : </td>
				<td>
					<select name="pizzaId">
						<c:forEach var="pizza" items="${pizzaList}">
							<option value="${pizza.pizzaId}">${pizzaVO.pizzaName}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>음료 선택 : </td>
				<td>
					<select name="drinkId">
						<c:forEach var="drink" items="${drinkList}">
							<option value="${drink.drinkId}">${drinkVO.drinkName}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
		</table>
		<input type="submit" value="등록" />&nbsp; <input type="button" value="재작성" onclick="goHome();"> <br />
		<a href="<c:url value="/menu/menuList.do" />">목록으로...</a>
	</form>
</body>
</html>