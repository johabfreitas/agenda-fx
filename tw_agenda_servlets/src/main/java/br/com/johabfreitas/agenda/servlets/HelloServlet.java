package br.com.johabfreitas.agenda.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{

	private static final long serialVersionUID = -8220437216673901916L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Olá a partir do servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>Olá mundo! Vim do servlet</p>");
		out.println("</body>");
		out.println("</html>");
	}

	
}
