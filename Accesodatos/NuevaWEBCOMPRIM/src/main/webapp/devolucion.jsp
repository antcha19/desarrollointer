<%-- 
    Document   : devolucion
    Created on : 20 ene. 2021, 16:27:47
    Author     : antonio
--%>

<<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import="modelo.GestionDevolucion,java.util.ArrayList,mx.com.gm.sga.domain.Devolucion"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Gestión de Devolucion</title>
    </head>
    <body>

        <c:set var="devolucion" value="${requestScope.devolucion}"/>

        <br/><br/><br/>

        <c:choose>

            <c:when test="${!empty devolucion}">

                <table border="1">
                    <tr>
                        <th>Id devolucion</th>
                        <th>Fecha devolucion </th>
                        <th>Id Wallet</th>
                        <th>Id Producto</th>
                       
                    </tr>

                    <c:forEach var="cont" items="${devolucion}">
                        <tr><td>${cont.iddevolucion}</td>
                            <td>${cont.fechadevolucion}</td>
                            <td>${cont.idwallet}</td>
                            <td>${cont.idproducto}</td>                       

                         
                           


                    </c:forEach>



                </table>
            </c:when>
            <c:otherwise>
                <h1>No hay devoluciones</h1>
            </c:otherwise>
        </c:choose>
        <br/>
        <br/>
        <a href="Controller?op=toMenu">Menu</a>
    </body>
</html>