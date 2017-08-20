<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Script test</title>
</head>
<body>
<p>脚本元素</p>

<%!
    //定义全局变量，不加！则是局部变量
    int count = 0;
    String[] color = {"red","blue"};
    //定义方法
    String getColor(int i){
    	return color[i];
    }
%>

<!-- JSP表达式输出测试 -->
<%=count++ %>    
<%=getColor(1) %>   

<!-- JSP脚本 -->
<%
  for(int i=1;i<10;i++){
	  out.println(i);	  
  }
%>


</body>
</html>