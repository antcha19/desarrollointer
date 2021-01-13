<%-- 
    Document   : ewallet
    Created on : 13 ene. 2021, 15:41:13
    Author     : antonio
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="modelo.GestionEwallet,java.util.ArrayList,mx.com.gm.sga.domain.Ewallet"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestión de Ewallet</title>
</head>
<body>
	
	<c:set var="ewallet" value="${requestScope.contactos}"/>
	
	<br/><br/><br/>
	
	<c:choose>
	
		<c:when test="${!empty ewallet}">
	
			<table border="1">
						<tr>
							<th>idwallet</th>
							<th>nombre </th>
							<th>apellidos</th>
                                                        <th>dni</th>
							<th>email </th>
							<th>saldopuntos</th>
                                                        <th>saldoeuros</th>
							<th></th>
						</tr>
						
						<c:forEach var="cont" items="${ewallet}">
							<tr><td>${cont.idwallet}</td>
							<td>${cont.nombre}</td>
							<td>${cont.apellidos}</td>
                                                        <tr><td>${cont.dni}</td>
							<td>${cont.email}</td>
							<td>${cont.saldopuntos}</td>
                                                        <td>${cont.saldoeuros}</td>
							<td><a href="Controller?op=doEliminar&idContacto=${cont.idwallet}">Eliminar</a></td></tr>
						
						
						</c:forEach>
						
						
						
			</table>
		</c:when>
		<c:otherwise>
			<h1>No hay wallets</h1>
		</c:otherwise>
	</c:choose>
	<br/>
	<br/>
	<a href="Controller?op=toMenu">Menu</a>
</body>
</html>