<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Posts</title>
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
</head>
<body>
	<div style="width: 1200px; margin-left: auto; margin-right: auto;">
		<table cellpadding="10">
			<tr>
				<th>Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Address</th>
				<th>Major</th>
				<th>Course Name</th>
				<th>Grade</th>

				<th></th>
			</tr>
			<c:forEach items="${AllPost}" var="p">
				<c:forEach items="${AllPostg}" var="g">
					<c:choose>
						<c:when test="${p.id==g.sid}">
							<tr>
								<td>${p.id}</td>
								<td>${p.firstname}</td>
								<td>${p.lastname}</td>
								<td>${p.address}</td>
								<td>${p.major}</td>
								<td>${g.coursename}</td>
								<td>${g.grade}</td>

								<td><a href="edit?id=${p.id}">Edit</a> <a
									href="delete?id=${p.id}">Delete</a></td>
							</tr>
						</c:when>
					</c:choose>
				</c:forEach>
			</c:forEach>
		</table>
		<br> <a href="AddNew.html">Insert Record</a>
	</div>
</body>
</html>