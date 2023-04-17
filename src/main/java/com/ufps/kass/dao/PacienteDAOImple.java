package com.ufps.kass.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;


import com.ufps.kass.modelo.Paciente;

public class PacienteDAOImple extends GenericDAO implements PacienteDAO{

	@Override
	public void insert(Paciente paciente) throws SQLException {
		// TODO Auto-generated method stub
		try {
            em.getTransaction().begin();;
            em.persist(paciente);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();

        }
	}

	@Override
	public Paciente select(int id) {
		// TODO Auto-generated method stub
		return em.find(Paciente.class, id);
	}

	@Override
	public List<Paciente> selectAll() {
		// TODO Auto-generated method stub
		String hql = "SELECT p FROM Paciente p";
        em = getEntityManager();
        Query query = em.createQuery(hql);
        return query.getResultList();
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		try {
            em.getTransaction().begin();;
            em.remove(em.merge(em.find(Paciente.class, id)));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();

        }
	}

	@Override
	public void update(Paciente paciente) throws SQLException {
		// TODO Auto-generated method stub
		try {
            em.getTransaction().begin();;
            em.merge(paciente);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
	}

}
