package com.ufps.kass.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ufps.kass.dao.PacienteDAO;
import com.ufps.kass.dao.PacienteDAOImple;
import com.ufps.kass.modelo.Paciente;

/**
 * Servlet implementation class PacienteServlet
 */
@WebServlet("/")
public class PacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PacienteDAO pacienteDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PacienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.pacienteDAO = new PacienteDAOImple();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		System.out.println(action);
		try {
		switch(action) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			insertarPaciente(request, response);
			break;
		case "/delete":
			eliminarPaciente(request, response);
			break;
		case "/update":
			actualizarPaciente(request, response);
			break;
		case "/edit":
			showEditForm(request, response);
			break;
			default: 
				listPacientes(request,response);
				break;
		}
		}catch(SQLException e) {
			throw new ServletException();
		}catch(ParseException pe) {
			pe.printStackTrace();
		}
		
		
	}

	private void listPacientes(HttpServletRequest request, HttpServletResponse response)  throws ServletException,SQLException, IOException{
		// TODO Auto-generated method stub
		List<Paciente> listPacientes = pacienteDAO.selectAll();
		request.setAttribute("listPacientes", listPacientes);
		for(Paciente paciente : listPacientes) {
			System.out.println(paciente);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("pacienteList.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		
		Paciente pacienteActual = pacienteDAO.select(id);
		request.setAttribute("paciente", pacienteActual);
		RequestDispatcher dispatcher = request.getRequestDispatcher("paciente.jsp");
		dispatcher.forward(request, response);
	}

	private void actualizarPaciente(HttpServletRequest request, HttpServletResponse response)  throws ServletException,SQLException, IOException, ParseException{
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String documento = request.getParameter("documento");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String genero = request.getParameter("genero");
		String fechaString = request.getParameter("fecha");
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = formatoDelTexto.parse(fechaString);
		String telefono = request.getParameter("telefono");
		String direccion = request.getParameter("direccion");
		double peso = Double.parseDouble(request.getParameter("peso"));
		double estatura = Double.parseDouble(request.getParameter("peso"));
		
		Paciente paciente = new Paciente(id,documento,nombre,apellido,email,genero,fecha,telefono,direccion,peso,estatura);
		pacienteDAO.update(paciente);
		
		response.sendRedirect("list");
	}

	private void eliminarPaciente(HttpServletRequest request, HttpServletResponse response)  throws ServletException,SQLException, IOException{
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		pacienteDAO.delete(id);
		response.sendRedirect("list");
	}

	private void insertarPaciente(HttpServletRequest request, HttpServletResponse response) throws ServletException,SQLException, IOException, ParseException {
		// TODO Auto-generated method stub
		
		String documento = request.getParameter("documento");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String genero = request.getParameter("genero");
		String fechaString = request.getParameter("fecha");
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = formatoDelTexto.parse(fechaString);
		String telefono = request.getParameter("telefono");
		String direccion = request.getParameter("direccion");
		double peso = Double.parseDouble(request.getParameter("peso"));
		double estatura = Double.parseDouble(request.getParameter("peso"));
		
		Paciente paciente = new Paciente(documento,nombre,apellido,email,genero,fecha,telefono,direccion,peso,estatura);
		pacienteDAO.insert(paciente);
		response.sendRedirect("list");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("paciente.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
