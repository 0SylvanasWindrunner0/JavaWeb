<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>转账功能</h1>
	<form action="transfer" method="post">
		转账账号：<input type="text" name="accOutAccNo" id="accOutAccNo"><br>
		密码：<input type="password" name="accOutPassword" id="accOutPassword"><br>
		金额：<input type="text" name="accOutBalance" id="accOutBalance"><br>
		收款账号：<input type="text" name="accInAccNo" id="accInAccNo"><br>
		转账姓名：<input type="text" name="accInName" id="accInName"><br>
		<input type="submit" value="转账">
	</form>
	
	<a href="logSearch.jsp">转账查询</a>
</body>
</html>