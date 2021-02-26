<%-- 
    Document   : home
    Created on : Dec 18, 2020, 12:36:46 AM
    Author     : maih_sofi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <div align="center">
    <h1>Trainer List</h1>
    <a href="new">Create New Trainer</a>
    <br/><br/>
    <table border="1" cellpadding="10">
        <thead>
            <tr>
                <th>ID</th>
                <th>First_Name</th>
                <th>Last_Name</th>
                <th>Subject</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listTrainers}" var="trainer" >
                <tr>
                    <td>${trainer.id}</td>
                    <td>${trainer.firstName}</td>
                    <td>${trainer.lastName}</td>
                    <td>${trainer.subject}</td>
                    <td>
                	<a href="<c:url value='${edit}/${trainer.id}' />">Edit</a>
                	&nbsp;&nbsp;&nbsp;
                	<a href="<c:url value='${delete}/${trainer.id}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>  
            
        </tbody>
    </table>
</div> 
    </body>
</html>
