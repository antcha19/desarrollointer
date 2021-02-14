package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestionCompra;
import modelo.GestionDevolucion;

import modelo.GestionEwallet;

/**
 * Servlet implementation class EliminaContacto
 */
@WebServlet("/EliminarEwallet")
public class EliminarEwallet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idcompra = Integer.parseInt(request.getParameter("idcompra"));
        GestionCompra gcompra = new GestionCompra();
        gcompra.eliminarcompra(idcompra);
        
        int iddevolucion = Integer.parseInt(request.getParameter("iddevolucion"));
        GestionDevolucion gdevolucion = new GestionDevolucion();
        gdevolucion.borrarDevolucion(iddevolucion);
        
        int id = Integer.parseInt(request.getParameter("idwallet"));
        GestionEwallet gwallet = new GestionEwallet();
        gwallet.borrarwallet(id);
        request.getRequestDispatcher("RecuperadorWallet").forward(request, response);
    }
    
}
