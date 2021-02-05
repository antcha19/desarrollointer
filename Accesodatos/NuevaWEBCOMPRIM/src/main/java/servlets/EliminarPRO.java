/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestionProducto;

/**
 *
 * @author antonio
 */
@WebServlet("/EliminarPRO")
public class EliminarPRO {
    	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("idproducto"));
		GestionProducto gproducto=new GestionProducto();
		gproducto.borrarwallet(id);
		request.getRequestDispatcher("RecuperarPRO").forward(request, response);
	}
}
