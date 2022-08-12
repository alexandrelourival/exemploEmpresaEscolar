package br.com.treinamento.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.treinamento.modelo.Curso;
import br.com.treinamento.modelo.Empresa;
import br.com.treinamento.modelo.Professor;
import br.com.treinamento.modelo.UnidadeEscola;

public class UnidadeEscolaDAO {
	private EntityManager em;

	public UnidadeEscolaDAO(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(UnidadeEscola unidadeEscola) {
		this.em.getTransaction().begin();
		this.em.persist(unidadeEscola);
		this.em.getTransaction().commit();
	}

	public void remover(UnidadeEscola unidadeEscola) {
		unidadeEscola = this.em.merge(unidadeEscola);
		this.em.remove(unidadeEscola);
	}

	public List<UnidadeEscola> consultarTodas() {
		String query = "SELECT uE FROM UnidadeEscola uE";
		return this.em.createQuery(query, UnidadeEscola.class).getResultList();
	}
	
	public UnidadeEscola consultarUnidadeEscolaPorId(Long id) {
		String query = "SELECT uE FROM UnidadeEscola uE WHERE uE.id = :id";
		return this.em.createQuery(query, UnidadeEscola.class).setParameter("id", id).getSingleResult();
	}
	
	public UnidadeEscola consultarUnidadeEscolaPorNome(String nome) {
		String query = "SELECT uE FROM UnidadeEscola uE WHERE uE.nome = :nome";
		return this.em.createQuery(query, UnidadeEscola.class).setParameter("nome", nome).getSingleResult();
	}

	public Empresa consultarEmpresaUnidadePorId(Long id) {
		String query = "SELECT uE FROM UnidadeEscola uE WHERE uE.id = :id";

		UnidadeEscola unidadeEscola = this.em.createQuery(query, UnidadeEscola.class).setParameter("id", id)
				.getSingleResult();

		return unidadeEscola.getEmpresa();
	}

	public List<Professor> consultarProfessoresUnidadePorId(Long id) {
		String query = "SELECT uE FROM UnidadeEscola uE WHERE uE.id = :id";

		UnidadeEscola unidadeEscola = this.em.createQuery(query, UnidadeEscola.class).setParameter("id", id)
				.getSingleResult();
		
		return unidadeEscola.getProfessores();
	}
	
	public List<Curso> consultarCursosUnidadePorId(Long id) {
		String query = "SELECT uE FROM UnidadeEscola uE WHERE uE.id = :id";

		UnidadeEscola unidadeEscola = this.em.createQuery(query, UnidadeEscola.class).setParameter("id", id)
				.getSingleResult();
		
		return unidadeEscola.getCursosUnidade();
	}
}
