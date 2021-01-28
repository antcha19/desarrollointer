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
import modelo.GestionCompra;
import mx.com.gm.sga.domain.Compra;

/**
 *
 * @author antonio
 */
@WebServlet("/RecuperarCOM")
public class RecuperarCOM extends  HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionCompra gcompra=new GestionCompra();
		List<Compra> compra=gcompra.recuperarcompras();
		//guardamos contactos en un atributo de petici�n
		request.setAttribute("compra", compra);
		//trasnferencia de la petici�n
		request.getRequestDispatcher("compra.jsp").forward(request, response);
	}
    
}
