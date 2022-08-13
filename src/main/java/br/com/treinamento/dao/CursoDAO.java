package br.com.treinamento.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.treinamento.modelo.Aluno;
import br.com.treinamento.modelo.Curso;
import br.com.treinamento.modelo.PeriodoCurso;
import br.com.treinamento.modelo.UnidadeEscola;

public class CursoDAO {
	private EntityManager em;

	public CursoDAO(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Curso curso) {
		this.em.getTransaction().begin();
		this.em.persist(curso);
		this.em.getTransaction().commit();
	}

	public void atualizar(Curso curso) {
		this.em.getTransaction().begin();
		curso = this.em.merge(curso);
		this.em.persist(curso);
		this.em.getTransaction().commit();
	}
	
	public void remover(Curso curso) {
		this.em.getTransaction().begin();
		curso = this.em.merge(curso);
		this.em.remove(curso);
		this.em.getTransaction().commit();
	}

	public List<Curso> consultarTodas() {
		String query = "SELECT c FROM Curso c";
		return this.em.createQuery(query, Curso.class).getResultList();
	}

	public Curso consultarCursoPorId(Long id) {
		String query = "SELECT c FROM Curso c WHERE c.id = :id";
		return this.em.createQuery(query, Curso.class).setParameter("id", id).getSingleResult();
	}

	public Curso consultarCursoPorNome(String nome) {
		String query = "SELECT c FROM Curso c WHERE c.nome = :nome";
		return this.em.createQuery(query, Curso.class).setParameter("nome", nome).getSingleResult();
	}

	public List<Aluno> consultarAlunosCursoPorId(Long id) {
		String query = "SELECT c FROM Curso c WHERE c.id = :id";

		Curso curso = this.em.createQuery(query, Curso.class).setParameter("id", id).getSingleResult();

		return curso.getAlunos();
	}

	public List<Aluno> consultarAlunosCursoPorNome(String nome) {
		String query = "SELECT c FROM Curso c WHERE c.nome = :nome";

		Curso curso = this.em.createQuery(query, Curso.class).setParameter("nome", nome).getSingleResult();

		return curso.getAlunos();
	}
	
	public List<PeriodoCurso> consultarPeriodosCursoPorId(Long id) {
		String query = "SELECT c FROM Curso c WHERE c.id = :id";

		Curso curso = this.em.createQuery(query, Curso.class).setParameter("id", id).getSingleResult();

		return curso.getPeriodosCursos();
	}

	public List<PeriodoCurso> consultarPeriodosCursoPorNome(String nome) {
		String query = "SELECT c FROM Curso c WHERE c.nome = :nome";

		Curso curso = this.em.createQuery(query, Curso.class).setParameter("nome", nome).getSingleResult();

		return curso.getPeriodosCursos();
	}
	
	public List<UnidadeEscola> consultarUnidadesEscolaresCursoPorId(Long id) {
		String query = "SELECT c FROM Curso c WHERE c.id = :id";

		Curso curso = this.em.createQuery(query, Curso.class).setParameter("id", id).getSingleResult();

		return curso.getUnidadesEscolares();
	}

	public List<UnidadeEscola> consultarUnidadesEscolaresCursoPorNome(String nome) {
		String query = "SELECT c FROM Curso c WHERE c.nome = :nome";

		Curso curso = this.em.createQuery(query, Curso.class).setParameter("nome", nome).getSingleResult();

		return curso.getUnidadesEscolares();
	}
}
