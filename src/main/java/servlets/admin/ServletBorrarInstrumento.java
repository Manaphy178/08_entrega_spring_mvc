package servlets.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.*;
import daosImpl.*;
import utilidadesSpring.ContenedorSpring;

@WebServlet("/admin/ServletBorrarInstrumento")
public class ServletBorrarInstrumento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Borrando instrumento");
		String id = request.getParameter("id");
		InstrumentosDAO dao = ContenedorSpring.obtenerContenedor(getServletContext())
				.getBean(InstrumentosDAOImpl.class);
		dao.borrarInstrumento(Integer.parseInt(id));
		response.sendRedirect("ServletListarInstrumento");
	}

}
