<%-- 
    Document   : new_trainer
    Created on : Dec 19, 2020, 11:57:50 AM
    Author     : maih_sofi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Trainer</title>
    </head>
    <body>
	<div align="center">
		<h1>Create New Trainer</h1>
		<br />
                <form:form method="POST" action="save" modelAttribute="trainer">

			<table border="0" cellpadding="10">
				<tr>
					<td>First Name:</td>
					<td><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td>Subject:</td>
					<td><form:input path="subject" /></td>
				</tr>
												
				<tr>
					<td colspan="2"><button type="submit">Save</button> </td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>
