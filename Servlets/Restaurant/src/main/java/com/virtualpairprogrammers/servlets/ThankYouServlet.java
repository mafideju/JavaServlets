package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ThankYouServlet extends HttpServlet {

	
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException {


		HttpSession session = request.getSession();
		Double total = (Double) session.getAttribute("total");

		if (total == null) {
			response.sendRedirect("/orderMenu.html");
		}

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body><h1>Ricky's Restaurant</h1>");
		out.println("<h2>Pedido recebido!!!</h2>");
		
		out.println("Agradecemos a preferência!!!.");
		out.println("Seu pedido custará R$" + total + " reais.");
				
		out.println("</body></html>");
		out.close();
		
	}
}
