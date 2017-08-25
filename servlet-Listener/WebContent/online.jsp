<%@page import="java.util.HashSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线人数统计</title>
</head>
<body>
    <!-- 获取sessionList -->
    <% HashSet sessionList = (HashSet)application.getAttribute("sessionList"); %>
    
    <!-- 2秒自动刷新 -->
    <% response.setIntHeader("Refresh", 2); %>
    
    <h3><%=sessionList.size() %> 人在线</h3>
    
</body>
</html>