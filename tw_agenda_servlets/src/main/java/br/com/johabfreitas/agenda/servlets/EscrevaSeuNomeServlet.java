package br.com.johabfreitas.agenda.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EscrevaSeuNomeServlet extends HttpServlet{

	private static final long serialVersionUID = 4833506948721656662L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<head>");
		out.println("		<title>ONome do usuário...</title>");
		out.println("	</head>");
		out.println("	<body>");
		out.println("		<form action=\"/receberMensagem\">");
		out.println("			<p>Digite seu nome:</p>");
		out.println("			<p><input type=\"text\" name=\"nomeUsuario\"></p>");
		out.println("			<p><button type=\"submit\">Enviar!</button></p>");
		out.println("		</form>");
		out.println("	</body>");
		out.println("</html>");
	}
	
	

}
