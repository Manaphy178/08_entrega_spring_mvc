package servlets.admin;

import java.io.IOException;

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

@WebServlet("/admin/ServletEditarInstrumento")
public class ServletEditarInstrumento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		InstrumentosDAO instrumentosDAO = ContenedorSpring.obtenerContenedor(getServletContext())
				.getBean(InstrumentosDAOImpl.class);
		Instrumento s = instrumentosDAO.obtenerInstrumentoPorId(Long.parseLong(id));
		request.setAttribute("instrumento", s);
		RequestDispatcher rd = request.getRequestDispatcher("instrumentos-editar.jsp");
		rd.forward(request, response);
	}

	

}
