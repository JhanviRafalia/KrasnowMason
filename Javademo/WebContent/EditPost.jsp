<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit</title>
</head>
<style>
.form-control {
	text-align: center;
	font-family: "Lucida Sans Unicode", "Lucida Grande", sans-serif;
	box-sizing: border-box;
}

h1 {
	font-family: "Lucida Sans Unicode", "Lucida Grande", sans-serif;
	color: #4CAF50;
	text-align: center;
}

div {
	width: 100%;
	border: 1px solid #fccb0a;
	padding: 5px;
	background-color: #D3D3D3;
}
</style>
<body>
	<h1>Edit Student Records</h1>
	<div style="width: 900px; margin-left: auto; margin-right: auto">
		<c:forEach items="${getStudentById}" var="p">
			<c:forEach items="${getGradesById}" var="g">
				<c:choose>
					<c:when test="${p.id==g.sid}">
						<form action="ManagerEditPost.jsp" method="post">
							<input type="hidden" name="id" class=form-control value="${p.id}">
							First Name:<br> <input type="text" value="${p.firstname}"
								name="firstname" style="width: 200px"><br> Last
							Name:<br> <input type="text" class=form-control
								value="${p.lastname}" name="lastname" style="width: 200px"><br>
							Address:<br>
							<textarea name="address" class=form-control
								style="width: 400px; height: 200px">${p.address}</textarea>
							<br> Major: <select name="major" class=form-control>
								<option value="${p.major}">${p.major}</option>
								<option value="cs">CS</option>
								<option value="swe">Swe</option>
								<option value="infs">infs</option>
							</select><br> Course Name:<br> <input type="text"
								name="coursename" value="${g.coursename}" class=form-control
								style="width: 200px"><br> Grades:<br> <input
								type="text" name="grade" value="${g.grade}" style="width: 200px"><br>
							<input type="submit" value="Submit">
						</form>
					</c:when>
				</c:choose>
			</c:forEach>
		</c:forEach>

	</div>
</body>
</html>
