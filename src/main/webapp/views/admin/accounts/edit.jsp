<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form
		modelAttribute="account"
		method="POST"
		action="/sof3021_assignment/admin/accounts/update">
		<div>
			<label>Fullname</label>
			<form:input name="fullname" path="fullname" />
		</div>
		<div>
			<label>Email</label>
			<form:input name="email" type="email" path="email" />
		</div>
		<div>
			<label>Username</label>
			<form:input name="username" path="username" />
		</div>
		<div>
			<label>Password</label>
			<form:password name="password" path="password" />
		</div>
		<div>
			<label>Photo</label>
			<form:input name="photo" path="photo" />
		</div>
	
		<button>Create</button>
	</form:form>
</body>
</html>