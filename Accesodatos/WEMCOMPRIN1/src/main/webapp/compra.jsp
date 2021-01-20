<%-- 
    Document   : compra
    Created on : 20 ene. 2021, 15:58:30
    Author     : antonio
--%>

<<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="modelo.GestionCompra,java.util.ArrayList,mx.com.gm.sga.domain.Compra"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Gestión de Compras</title>
    </head>
    <body>

        <c:set var="compra" value="${requestScope.compra}"/>

        <br/><br/><br/>

        <c:choose>

            <c:when test="${!empty compra}">

                <table border="1">
                    <tr>
                        <th>Id Compra</th>
                        <th>Fecha Compra </th>
                        <th>Id Wallet</th>
                        <th>Id Producto</th>
                        <th>Eliminar compra</th>
                    </tr>

                    <c:forEach var="cont" items="${compra}">
                        <tr><td>${cont.idcompra}</td>
                            <td>${cont.fechacompra}</td>
                            <td>${cont.idwallet}</td>
                            <td>${cont.idproducto}</td>
                    </c:forEach>



                </table>
            </c:when>
            <c:otherwise>
                <h1>No hay compras registradas</h1>
            </c:otherwise>
        </c:choose>
        <br/>
        <br/>
        <a href="Controller?op=toMenu">Menu</a>
    </body>
</html>