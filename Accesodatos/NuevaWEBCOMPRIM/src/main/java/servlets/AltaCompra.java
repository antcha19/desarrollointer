/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;


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
@WebServlet("/AltaCompra")
public class AltaCompra extends HttpServlet{
    
     private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idwallet = Integer.parseInt(request.getParameter("idwallet"));
        int idproducto = Integer.parseInt(request.getParameter("idproducto"));
        java.util.Date fecha = new java.util.Date();
        long lo = fecha.getTime();
        java.sql.Date fechadate = new java.sql.Date(lo);
        GestionCompra gcompra = new GestionCompra();
        gcompra.nuevacompra(fechadate, idwallet, idproducto);
        request.getRequestDispatcher("index.html").forward(request, response);
    } 
    
    
    
}
