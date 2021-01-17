/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestionProducto;
import mx.com.gm.sga.domain.Producto;

/**
 *
 * @author antonio
 */
@WebServlet("/RecuperarPRO")
public  class RecuperarPRO extends HttpServlet{
    private static  final long serialVersionUID = 1L;
    
    /**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionProducto gproducto=new GestionProducto();
		List<Producto> pro=gproducto.recuperarproductos();
		//guardamos contactos en un atributo de petici�n
		request.setAttribute("pro", pro);
		//trasnferencia de la petici�n
		request.getRequestDispatcher("producto.jsp").forward(request, response);
	}
    
    
}
