package br.com.treinamento.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.treinamento.modelo.Empresa;
import br.com.treinamento.modelo.UnidadeEscola;

public class EmpresaDAO {

	private EntityManager em;

	public EmpresaDAO(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Empresa empresa) {
		this.em.getTransaction().begin();
		this.em.persist(empresa);
		this.em.getTransaction().commit();
	}

	public void remover(Empresa empresa) {
		empresa = this.em.merge(empresa);
		this.em.remove(empresa);
	}

	public List<Empresa> consultarTodas() {
		String query = "SELECT e FROM Empresa e";
		return this.em.createQuery(query, Empresa.class).getResultList();
	}

	public List<UnidadeEscola> consultarUnidadesEscolaresEmpresaPorNome(String nome_empresa) {
		String query = "SELECT e FROM Empresa e WHERE e.nome = :nome_empresa";

		Empresa empresa = this.em.createQuery(query, Empresa.class).setParameter("nome_empresa", nome_empresa)
				.getSingleResult();

		return empresa.getUnidadesEscolares();
	}

	public List<UnidadeEscola> consultarUnidadesEscolaresEmpresaPorId(Long id) {
		String query = "SELECT e FROM Empresa e WHERE e.id = :id";

		Empresa empresa = this.em.createQuery(query, Empresa.class).setParameter("id", id)
				.getSingleResult();

		return empresa.getUnidadesEscolares();
	}

}