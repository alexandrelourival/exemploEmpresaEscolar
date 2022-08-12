package br.com.treinamento.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.treinamento.modelo.Professor;
import br.com.treinamento.modelo.UnidadeEscola;

public class ProfessorDAO {
	private EntityManager em;

	public ProfessorDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Professor professor) {
		this.em.getTransaction().begin();
		this.em.persist(professor);
		this.em.getTransaction().commit();
		
	}
	
	public void remover(Professor professor) {
		professor = this.em.merge(professor);
		this.em.remove(professor);
	}
	
	public List<Professor> consultarTodas(){
		String query = "SELECT p FROM Professor p";
		return this.em.createQuery(query, Professor.class).getResultList();
	}
	
	public Professor consultarProfessorPorId(Long id){
		String query = "SELECT p FROM Professor p WHERE p.id = :id";
		return this.em.createQuery(query, Professor.class).setParameter("id",id).getSingleResult();
	}
	
	public Professor consultarProfessorPorPISPASEP(String pispasep){
		String query = "SELECT p FROM Professor p WHERE p.pispasep = :pispasep";
		return this.em.createQuery(query, Professor.class).setParameter("pispasep",pispasep).getSingleResult();
	}
	
	public List<UnidadeEscola> consultarUnidadesProfessorPorId(Long id){
		String query = "SELECT p FROM Professor p WHERE p.id = :id";
		
		Professor professor = this.em.createQuery(query, Professor.class).setParameter("id",id).getSingleResult();
		
		return professor.getUnidadesEscolas();
	}
	
	public List<UnidadeEscola> consultarUnidadesProfessorPorPISPASEP(String pispasep){
		String query = "SELECT p FROM Professor p WHERE p.pispasep = :pispasep";
		
		Professor professor = this.em.createQuery(query, Professor.class).setParameter("pispasep",pispasep).getSingleResult();
		
		return professor.getUnidadesEscolas();
	}

}
