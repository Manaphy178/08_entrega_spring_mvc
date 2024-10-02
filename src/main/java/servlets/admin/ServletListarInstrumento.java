package servlets.admin;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.InstrumentosDAO;
import daosImpl.InstrumentosDAOImpl;
import modelo.Instrumento;
import utilidadesSpring.ContenedorSpring;

@WebServlet("/admin/ServletListarInstrumento")
public class ServletListarInstrumento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InstrumentosDAO instrumentosDAO = ContenedorSpring.obtenerContenedor(getServletContext())
				.getBean(InstrumentosDAOImpl.class);
		List<Instrumento> instrumento = instrumentosDAO.obtenerInstrumentos();
		request.setAttribute("info", instrumento);
		RequestDispatcher rd = request.getRequestDispatcher("instrumentos.jsp");
		rd.forward(request, response);
	}

}
