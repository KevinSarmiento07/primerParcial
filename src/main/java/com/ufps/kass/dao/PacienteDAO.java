package com.ufps.kass.dao;

import java.sql.SQLException;
import java.util.List;

import com.ufps.kass.modelo.Paciente;



public interface PacienteDAO {
	public void insert(Paciente paciente) throws SQLException;
	public Paciente select(int id);
	public List<Paciente> selectAll();
	public void delete(int id) throws SQLException;
	public void update(Paciente paciente)throws SQLException;
}
