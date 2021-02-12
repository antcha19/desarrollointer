package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import modelo.GestionEwallet;
import mx.com.gm.sga.domain.Ewallet;

/**
 * Servlet implementation class RecuperadorWallet
 */
@WebServlet("/RecuperadorWallet")
public class RecuperadorWallet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionEwallet gwallet=new GestionEwallet();
		List<Ewallet> ewallet=gwallet.recuperarwallets();
		//guardamos contactos en un atributo de petici�n
		request.setAttribute("ewallet", ewallet);
		//trasnferencia de la petici�n
		request.getRequestDispatcher("ewallet.jsp").forward(request, response);
	}

}
