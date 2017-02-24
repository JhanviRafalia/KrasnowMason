<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit</title>
    </head>
    <body>
        <h1>Edit Student Records</h1>
        <div style="width: 900px; margin-left: auto; margin-right: auto">
            <c:forEach items="${getStudentById}" var="p">
            <c:forEach items="${getGradesById}" var="g">
            <c:choose>
               <c:when test="${p.id==g.sid}">
                <form action="ManagerEditPost.jsp" method="post">
                    <input type="hidden" name="id" value="${p.id}">
                    First Name:<br>
                    <input type="text" value="${p.firstname}" name="firstname" style="width: 200px"><br>
                    Last Name:<br>
                    <input type="text" value="${p.lastname}" name="lastname" style="width: 200px"><br>
                    Address:<br>
                    <textarea  name="address" style="width: 400px; height: 200px">${p.address}</textarea><br>
                    Major: 
                    <select name="major">
                        <option value="${p.major}">${p.major}</option>
                        <option value="cs">CS</option>
                        <option value="swe">Swe</option>
                        <option value="infs">infs</option>
                    </select><br>
                    Course Name:<br>
                <input type="text" name="coursename" value="${g.coursename}" style="width: 200px"><br>
                Grades:<br>
                <input type ="text" name ="grade" value="${g.grade}" style="width: 200px"><br>
                    <input type="submit" value="Submit">
                </form>
                </c:when>
                </c:choose>
                </c:forEach>
            </c:forEach>

        </div>
    </body>
</html>
