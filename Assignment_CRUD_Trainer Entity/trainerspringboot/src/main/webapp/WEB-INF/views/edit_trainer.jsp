<%-- 
    Document   : edit_trainer
    Created on : Dec 19, 2020, 2:37:12 PM
    Author     : maih_sofi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="utf-8" />
<title>Edit Trainer</title>
</head>
<body >
	<div align="center">
		<h1>Edit|Update Trainer</h1>
		<br />
                
                <% 
                    String updateUrlFINAL = request.getContextPath() + "/save" ;
                    session.setAttribute("updateUrlFINAL", updateUrlFINAL);
                %>
		<br />
                <form:form method="POST" action="${updateUrlFINAL}" modelAttribute="trainer">

			<table border="0" cellpadding="10">
                                <tr>
					<td hidden><form:input path="id" /></td>
				</tr>
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
