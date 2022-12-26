package br.com.johabfreitas.agenda.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MensagemServlet extends HttpServlet {

	private static final long serialVersionUID = 184660165766836874L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<head>");
		out.println("		<title>Nome do usuário...</title>");
		out.println("	</head>");
		out.println("	<body>");
		out.println("		<form action=\"/tw_agenda_servlets/mensagem\" method=\"post\">");
		out.println("			<p>Digite seu nome:</p>");
		out.println("			<p><input type=\"text\" name=\"nomeUsuario\"></p>");
		out.println("			<p><button type=\"submit\">Enviar!</button></p>");
		out.println("		</form>");
		out.println("	</body>");
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
