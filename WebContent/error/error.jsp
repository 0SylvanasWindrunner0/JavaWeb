<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>错误码：${code}</p>
	<p>错误原因：
	<%
        int code = Integer.parseInt(session.getAttribute("code").toString());

        switch(code) {
            case 1:
                out.println("账号密码不匹配");
                break;
            case 2:
                out.println("账户金额不足");
                break;
            case 3:
                out.println("账号姓名不匹配");
                break;
            case 4:
                out.println("转账失败");
                break;
            default:
                out.println("nothing");
        }
    %></p>
	
</body>
</html>