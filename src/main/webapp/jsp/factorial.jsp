<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%!
	public String hello(){
		return "hello~";
	}

	public int factorial(int fac){
		//0! 수학적 정의에 따라 1
		if(fac == 0){
			return 1;			
		}else{
			return factorial(fac-1)*fac;
		}
	}
%>
	hello() : <%= hello() %><br>
	factorial(1) : <%= factorial(1) %><br>
	factorial(2) : <%= factorial(2) %><br>
	factorial(3) : <%= factorial(3) %><br>
	factorial(4) : <%= factorial(4) %><br>
	factorial(5) : <%= factorial(5) %><br>
	factorial(6) : <%= factorial(6) %><br>
	factorial(7) : <%= factorial(7) %><br>
	factorial(8) : <%= factorial(8) %><br>
<%
	int result = 1;
	for(int i=1; i<9; i++){
		result = result * i;
%>
	factorial(<%=i%>) : <%=result%><br>
<%
	}
%>

</body>
</html>