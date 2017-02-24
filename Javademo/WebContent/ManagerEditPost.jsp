
<%@page import="com.gmu.databasedemo.dao.DataAccess"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String idTemp = request.getParameter("id");
            int id = Integer.parseInt(idTemp);
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String address = request.getParameter("address");
            String major = request.getParameter("major");
            String coursename = request.getParameter("coursename");
            String grade = request.getParameter("grade");
            
            
            DataAccess da = new DataAccess();
            da.edit(id, firstname, lastname, address, major);
            da.editgrades(id, coursename, grade);
            
            response.sendRedirect("AllPost");
        %>
    </body>
</html>