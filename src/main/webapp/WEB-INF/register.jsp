<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-4">
				<h1>Regístrate</h1>
				<form:form action="/registration" method="post" modelAttribute="user">
					<div class="form-group">
						<form:label path="username">Username:</form:label>
						<form:input path="username" class="form-control"/>
						<form:errors path="username" class="text-danger"/>
					</div>
						<div class="form-group">
						<form:label path="password">Password:</form:label>
						<form:input path="password" type="password" class="form-control"/>
						<form:errors path="password" class="text-danger"/>
					</div>
						<div class="form-group">
						<form:label path="confirm">Confirm password:</form:label>
						<form:input path="confirm" type="password" class="form-control"/>
						<form:errors path="confirm" class="text-danger"/>
					</div>
					<input type="submit" value="Registrarme" class="btn btn-success"/>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>