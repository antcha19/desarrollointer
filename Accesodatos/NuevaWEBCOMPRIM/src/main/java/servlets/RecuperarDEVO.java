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
import modelo.GestionDevolucion;
import mx.com.gm.sga.domain.Devolucion;

/**
 *
 * @author antonio
 */
@WebServlet("/RecuperarDEVO")
public class RecuperarDEVO extends HttpServlet{
    
    private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionDevolucion gdevolucion=new GestionDevolucion();
		List<Devolucion> devolucion=gdevolucion.recuperardevolucion();
		//guardamos contactos en un atributo de petici�n
		request.setAttribute("devolucion", devolucion);
		//trasnferencia de la petici�n
		request.getRequestDispatcher("devolucion.jsp").forward(request, response);
	}
    
}
