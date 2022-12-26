package br.com.johabfreitas.agenda.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ReceberMensagemServlet extends HttpServlet{

	private static final long serialVersionUID = 1411151382376537576L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeUsuario = request.getParameter("nomeUsuario");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<head>");
		out.println("		<title>Nome do usuário!</title>");
		out.println("	</head>");
		out.println("	<body>");
		out.println("		<p>Olá, " + nomeUsuario + "</p>");
		out.println("	</body>");
		out.println("</html>");
	}

	
}
