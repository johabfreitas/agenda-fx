package br.com.johabfreitas.agenda.servlets.agenda;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.johabfreitas.agenda.entidades.Contato;
import br.com.johabfreitas.agenda.repositorios.impl.ContatoRepositorioJdbc;
import br.com.johabfreitas.agenda.respositorios.interfaces.AgendaRepositorio;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/agenda/listar" })
public class ListaContatosServlet extends HttpServlet {

	private static final long serialVersionUID = -4429701579359704252L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AgendaRepositorio<Contato> agendaRepositorio = new ContatoRepositorioJdbc();
		try {
			List<Contato> contatos = agendaRepositorio.selecionar();
			request.setAttribute("listaContatos", contatos);
		} catch (SQLException e) {
			request.setAttribute("mensagemErro", e.getMessage());
		}
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/paginas/agenda/listaContatos.jsp");
		dispatcher.forward(request, response);
	}

}
