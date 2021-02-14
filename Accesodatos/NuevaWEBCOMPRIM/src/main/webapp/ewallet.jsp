<%-- 
    Document   : ewallet
    Created on : 15 ene. 2021, 14:22:11
    Author     : antonio
--%>

<<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="modelo.GestionEwallet,java.util.ArrayList,mx.com.gm.sga.domain.Ewallet"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Gestión de Ewallet</title>
    </head>
    <body>

        <c:set var="ewallet" value="${requestScope.ewallet}"/>

        <br/><br/><br/>

        <c:choose>

            <c:when test="${!empty ewallet}">

                <table border="1">
                    <tr>
                        <th>id wallet</th>
                        <th>Nombre </th>
                        <th>Apellidos</th>
                        <th>DNI</th>
                        <th>Fecha de Nacimiento</th>
                        <th>Email </th>
                        <th>Saldo punto</th>
                        <th>Saldo euros</th>
                        <th>Eliminar wallet</th>
                    </tr>

                    <c:forEach var="cont" items="${ewallet}">
                        <tr><td>${cont.idwallet}</td>
                            <td>${cont.nombre}</td>
                            <td>${cont.apellidos}</td>
                            <td>${cont.dni}</td>
                            <td>${cont.fechanacimiento}</td>
                            <td>${cont.email}</td>
                            <td>${cont.saldopuntos}</td>
                             <td>${cont.saldoeuros}</td>
                            <td><a href="Controller?op=doEliminarWallet&idwallet=${cont.idwallet}">Eliminar</a></td></tr>


                    </c:forEach>



                </table>
            </c:when>
            <c:otherwise>
                <h1>No hay wallet</h1>
            </c:otherwise>
        </c:choose>
        <br/>
        <br/>
        <a href="Controller?op=toMenu">Menu</a>
    </body>
</html>