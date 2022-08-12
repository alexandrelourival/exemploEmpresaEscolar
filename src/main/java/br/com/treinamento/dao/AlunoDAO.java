package br.com.treinamento.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.treinamento.modelo.Aluno;
import br.com.treinamento.modelo.Curso;

public class AlunoDAO {
	private EntityManager em;

	public AlunoDAO(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Aluno aluno) {
		this.em.getTransaction().begin();
		this.em.persist(aluno);
		this.em.getTransaction().commit();
	}

	public void remover(Aluno aluno) {
		aluno = this.em.merge(aluno);
		this.em.remove(aluno);
	}

	public List<Aluno> consultarTodas() {
		String query = "SELECT a FROM Aluno a";
		return this.em.createQuery(query, Aluno.class).getResultList();
	}

	public Aluno consultarAlunoPorId(Long id) {
		String query = "SELECT a FROM Aluno a WHERE a.id = :id";
		return this.em.createQuery(query, Aluno.class).setParameter("id", id).getSingleResult();
	}

	public Aluno consultarAlunoPorNome(String nome) {
		String query = "SELECT a FROM Aluno a WHERE a.id = :nome";
		return this.em.createQuery(query, Aluno.class).setParameter("nome", nome).getSingleResult();
	}

	public List<Curso> consultarCursosAlunoPorId(Long id) {
		String query = "SELECT a FROM Aluno a WHERE a.id = :id";

		Aluno aluno = this.em.createQuery(query, Aluno.class).setParameter("id", id).getSingleResult();

		return aluno.getCursos();
	}

	public List<Curso> consultarCursosAlunoPorNome(String nome) {
		String query = "SELECT a FROM Aluno a WHERE a.id = :nome";
		
		Aluno aluno = this.em.createQuery(query, Aluno.class).setParameter("nome", nome).getSingleResult();

		return aluno.getCursos();
	}
}
