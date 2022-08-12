package br.com.treinamento.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.treinamento.modelo.DisciplinaOferecida;
import br.com.treinamento.modelo.PeriodoCurso;

public class DisciplinaOferecidaDAO {
	private EntityManager em;

	public DisciplinaOferecidaDAO(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(DisciplinaOferecida disciplinaOferecida) {
		this.em.getTransaction().begin();
		this.em.persist(disciplinaOferecida);
		this.em.getTransaction().commit();
	}

	public void remover(DisciplinaOferecida disciplinaOferecida) {
		disciplinaOferecida = this.em.merge(disciplinaOferecida);
		this.em.remove(disciplinaOferecida);
	}

	public List<DisciplinaOferecida> consultarTodas() {
		String query = "SELECT dO FROM DisciplinaOferecida dO";
		return this.em.createQuery(query, DisciplinaOferecida.class).getResultList();
	}

	public DisciplinaOferecida consultarDisciplinaOferecidaPorId(Long id) {
		String query = "SELECT dO FROM DisciplinaOferecida dO WHERE dO.id = :id";

		return this.em.createQuery(query, DisciplinaOferecida.class).setParameter("id", id).getSingleResult();
	}

	public DisciplinaOferecida consultarDisciplinaOferecidaPorNome(String nome) {
		String query = "SELECT dO FROM DisciplinaOferecida dO WHERE dO.nome = :nome";

		return this.em.createQuery(query, DisciplinaOferecida.class).setParameter("nome", nome).getSingleResult();
	}

	public PeriodoCurso consultarPeriodoDisciplinaOferecidaPorId(Long id) {
		String query = "SELECT dO FROM DisciplinaOferecida dO WHERE dO.id = :id";
		
		DisciplinaOferecida disciplinaOferecida = this.em.createQuery(query, DisciplinaOferecida.class).setParameter("id", id).getSingleResult();
		
		return disciplinaOferecida.getPeriodoCurso();
	}

	public PeriodoCurso consultarPeriodoDisciplinaOferecidaPorNome(String nome) {
		String query = "SELECT dO FROM DisciplinaOferecida dO WHERE dO.nome = :nome";

		DisciplinaOferecida disciplinaOferecida = this.em.createQuery(query, DisciplinaOferecida.class)
				.setParameter("nome", nome).getSingleResult();

		return disciplinaOferecida.getPeriodoCurso();
	}

}
