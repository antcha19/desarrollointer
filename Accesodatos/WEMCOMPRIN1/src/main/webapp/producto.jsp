<%-- 
    Document   : producto
    Created on : 16 ene. 2021, 9:49:39
    Author     : antonio
--%>

<<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="modelo.GestionProducto,java.util.ArrayList,mx.com.gm.sga.domain.Producto"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Gestión de Productos</title>
    </head>
    <body>

        <c:set var="pro" value="${requestScope.pro}"/>

        <br/><br/><br/>

        <c:choose>

            <c:when test="${!empty pro}">

                <table border="1">
                    <tr>
                        <th>id producto</th>
                        <th>Nombre del producto </th>
                        <th>Precio del producto</th>
                        <th>Puntos del producto</th>

                    </tr>

                    <c:forEach var="cont" items="${pro}">
                        <tr><td>${cont.idproducto}</td>
                            <td>${cont.nombreproducto}</td>
                            <td>${cont.precioproducto}</td>
                            <td>${cont.puntosproducto}</td>
                            <td><a href="Controller?op=eliminarpro&idproducto=${cont.idproducto}">Eliminar</a></td></tr>


                    </tr>


                </c:forEach>



            </table>
        </c:when>
        <c:otherwise>
            <h1>No hay Productos</h1>
        </c:otherwise>
    </c:choose>
    <br/>
    <br/>
    <a href="Controller?op=toMenu">Menu</a>
</body>
</html>