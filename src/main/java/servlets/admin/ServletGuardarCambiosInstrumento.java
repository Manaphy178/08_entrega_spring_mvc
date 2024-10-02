package servlets.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.InstrumentosDAO;
import daosImpl.InstrumentosDAOImpl;
import modelo.Instrumento;
import utilidadesSpring.ContenedorSpring;


@WebServlet("/admin/ServletGuardarCambiosInstrumento")
public class ServletGuardarCambiosInstrumento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Instrumento i = new Instrumento();
		i.setNombre(request.getParameter("nombre"));
		i.setTipo(request.getParameter("tipo"));
		i.setMarca(request.getParameter("marca"));
		i.setGamma(request.getParameter("gamma"));
		i.setDesc(request.getParameter("description"));
		i.setPrecio(Double.parseDouble(request.getParameter("precio")));
		i.setId(Integer.parseInt(request.getParameter("id")));
		InstrumentosDAO instrumentoDAO = ContenedorSpring.obtenerContenedor(getServletContext())
				.getBean(InstrumentosDAOImpl.class);
		instrumentoDAO.actualizarInstrumento(i);
		response.sendRedirect("ServletListarInstrumento");
	}

}
