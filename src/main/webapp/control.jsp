<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 	
	
		String open_id = request.getParameter("ID");
		String nombre = request.getParameter("Nombre");
		String ruta_foto = request.getParameter("Foto");
		String correo = request.getParameter("Email");
		String nacimiento = request.getParameter("Nacimiento");
		//out.println(open_id);
		
		//response.sendRedirect("http://localhost:8080/spring-rest-client/agenda/getuser/"+15);
		//response.sendRedirect("http://localhost:8080/spring-rest-client/agenda/getuserOI/"+open_id);
		
	%>
</body>
</html>