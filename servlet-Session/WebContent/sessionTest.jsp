<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cookie test</title>
</head>
<body>
    <form action="loginServlet" method="post">
                      用户名：
       <input type="text" name="username"><br/>
                       密　码：
       <input type="text" name="password"><br/>
       <input type="submit" value="登陆">
    </form>
    
    <form action="loginServlet" method="get">
                      用户名：
       <input type="text" name="username"><br/>
                       密　码：
       <input type="text" name="password"><br/>
       <input type="submit" value="登陆">
    </form>
</body>
</html>