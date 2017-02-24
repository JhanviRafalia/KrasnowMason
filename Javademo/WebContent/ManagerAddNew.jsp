<%@page import="com.gmu.databasedemo.dao.DataAccess"%>
<%@page import="com.gmu.database.model.Student"%>
<%@page import="com.gmu.database.model.Grades"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	DataAccess da = new DataAccess();
 	

	
	String firstname = request.getParameter("firstname");
	String lastname= request.getParameter("lastname");
	String address = request.getParameter("address");
	String major = request.getParameter("major");
	String coursename= request.getParameter("coursename");
	String grade= request.getParameter("grade");
	
	//Student stud=da.searchbyStudentById(id);

	Student s = new Student( firstname, lastname, address, major);
	Grades g = new Grades( coursename, grade);
	
	
	da.addNew(s);
	da.addNewGrade(g);
	//request.setAttribute("AllPost", DataAccess.getAll());
	response.sendRedirect("AllPost");

%>

</body>
</html>