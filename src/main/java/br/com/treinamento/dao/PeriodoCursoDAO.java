package br.com.treinamento.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.treinamento.modelo.Curso;
import br.com.treinamento.modelo.DisciplinaOferecida;
import br.com.treinamento.modelo.PeriodoCurso;

public class PeriodoCursoDAO {
	private EntityManager em;

	public PeriodoCursoDAO(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(PeriodoCurso periodoCurso) {
		this.em.getTransaction().begin();
		this.em.persist(periodoCurso);
		this.em.getTransaction().commit();
	}

	public void atualizar(PeriodoCurso periodoCurso) {
		this.em.getTransaction().begin();
		periodoCurso = this.em.merge(periodoCurso);
		this.em.persist(periodoCurso);
		this.em.getTransaction().commit();
	}

	public void remover(PeriodoCurso periodoCurso) {
		this.em.getTransaction().begin();
		periodoCurso = this.em.merge(periodoCurso);
		this.em.remove(periodoCurso);
		this.em.getTransaction().commit();
	}

	public List<PeriodoCurso> consultarTodas() {
		String query = "SELECT pC FROM PeriodoCurso pC";
		return this.em.createQuery(query, PeriodoCurso.class).getResultList();
	}

	public PeriodoCurso consultarPeriodoCursoPorId(Long id) {
		String query = "SELECT pC FROM PeriodoCurso pC WHERE pC.id = :id";

		return this.em.createQuery(query, PeriodoCurso.class).setParameter("id", id).getSingleResult();
	}

	public PeriodoCurso consultarPeriodoCursoPorNome(String nome) {
		String query = "SELECT pC FROM PeriodoCurso pC WHERE pC.id = :nome";

		return this.em.createQuery(query, PeriodoCurso.class).setParameter("nome", nome).getSingleResult();
	}

	public Curso consultarCursoPeriodoCursoPorId(Long id) {
		String query = "SELECT pC FROM PeriodoCurso pC WHERE pC.id = :id";

		PeriodoCurso periodoCurso = this.em.createQuery(query, PeriodoCurso.class).setParameter("id", id)
				.getSingleResult();

		return periodoCurso.getCurso();
	}

	public Curso consultarCursoPeriodoCursoPorNome(String nome) {
		String query = "SELECT pC FROM PeriodoCurso pC WHERE pC.id = :nome";

		PeriodoCurso periodoCurso = this.em.createQuery(query, PeriodoCurso.class).setParameter("nome", nome)
				.getSingleResult();

		return periodoCurso.getCurso();
	}

	public List<DisciplinaOferecida> consultarDisciplinasPeriodoCursoPorId(Long id) {
		String query = "SELECT pC FROM PeriodoCurso pC WHERE pC.id = :id";

		PeriodoCurso periodoCurso = this.em.createQuery(query, PeriodoCurso.class).setParameter("id", id)
				.getSingleResult();

		return periodoCurso.getDisciplinasOferecidas();
	}

	public List<DisciplinaOferecida> consultarDisciplinasPeriodoCursoPorNome(String nome) {
		String query = "SELECT pC FROM PeriodoCurso pC WHERE pC.id = :nome";

		PeriodoCurso periodoCurso = this.em.createQuery(query, PeriodoCurso.class).setParameter("nome", nome)
				.getSingleResult();

		return periodoCurso.getDisciplinasOferecidas();
	}

}
