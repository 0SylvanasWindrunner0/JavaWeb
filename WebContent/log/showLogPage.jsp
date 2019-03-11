<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table border="1">
		<tr>
			<th>转出账号</th>
			<th>转入账号</th>
			<th>转账时间</th>
			<th>转账金额</th>
		</tr>
		<c:forEach items="${pageInfo.list}" var="pi">
			<tr>
				<th>${pi.accOut}</th>
				<th>${pi.accIn}</th>
				<th>${pi.time}</th>
				<th>${pi.money}</th>
			</tr>	
		</c:forEach>
	</table>
	<a href="showLogServlet?pageNumber=${pageInfo.pageNumber-1 }&pageSize=${pageInfo.pageSize}" <c:if test="${pageInfo.pageNumber<=1 }"> onclick="javascript:return false;" </c:if> >上一页</a>
	<a href="showLogServlet?pageNumber=${pageInfo.pageNumber+1 }&pageSize=${pageInfo.pageSize}" <c:if test="${pageInfo.pageNumber>=pageInfo.pageTotal }">onclick="javascript:return false;" </c:if>>下一页</a>
</body>
</html>